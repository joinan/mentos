#!/usr/bin/env node

/**
 * 
 * 
 * 
 * 
 * Module dependencies.
 */

var app = require('../app');
var debug = require('debug')('web:server');
var http = require('http');
var R = require('r-script');
var exec = require('child_process').exec;
/**
 * Get port from environment and store in Express.
 */

var port = normalizePort(process.env.PORT || '3000');
app.set('port', port);

/**
 * Create HTTP server.
 */

var server = http.createServer(app);

var MongoClient = require('mongodb').MongoClient;
var ObjectID = require('mongodb').ObjectID;

//Connection URL 
var url = 'mongodb://localhost:27017/mentos';
//Use connect method to connect to the Server 
var dbObj = null;
MongoClient.connect(url, function(err, db) {
  if(!err){
    console.log("Connected correctly to server");
    dbObj = db;
  }else{
    console.log(err);
  }
//db.close();
});

var mysql =require('mysql');
var conn = mysql.createConnection({
  host  : 'localhost', // 주소
  user  : 'root', // 사용자
  password: 'root', // 비밀번호
  database: 'mentos' // db이름
});
// mysql 연결
conn.connect();

var socketio = require('socket.io');
var io = socketio.listen(server);
io.sockets.on('connection', function(socket){
  console.log('connection');
  //////////////////////////
  var mentos = dbObj.collection('mentos');

  socket.on('delete_note', function(data){
    data = JSON.parse(data);
    mentos.remove({_id:ObjectID.createFromHexString(data._id)}, function(err, result){
      socket.emit('delete_note', JSON.stringify(result));
    });
  });

  socket.on('load_note', function(data){
    data = JSON.parse(data);
    mentos.find({c_no:data.c_no}).toArray(function(err, results){
      socket.emit('load_note', JSON.stringify(results));
    });
  });

  socket.on('insert_note', function(data){
    data = JSON.parse(data);
    mentos.save({c_no:Number(data.c_no), c_title:data.c_title, c_content:data.c_content, created_at:data.created_at}, function(err, result){
      if(err) console.log(err);
      else {
        console.log(result);
        socket.emit('insert_note', JSON.stringify(result));
      }
    });
  });
  
  socket.on('load_consult', function(data){
	    data = JSON.parse(data);
	    mentos.find({c_no:data.c_no}).toArray(function(err, results){
	      socket.emit('consult_list', JSON.stringify(results));
	    });
  });
  
  socket.on('insert_consult', function(data){
	    data = JSON.parse(data);
	    mentos.save({c_no:Number(data.c_no), consult_content:data.consultContent, created:data.created}, function(err, result){
	      if(err) console.log(err);
	      else {
	        console.log(result);
	        socket.emit('insert_consult', JSON.stringify(result));
	      }
	    });
  });

  socket.on('sentiment', function(data){
      data = JSON.parse(data);
      var cmd = 'Rscript ../r/sentiment.R ' + data._id.toString();
      exec(cmd, function(err, stdout, stderr){
          if (err) {
              console.error(err);
              return;
          }
          if(stdout){
              console.log(stdout);
              mentos.find({_id:ObjectID.createFromHexString(data._id)}).toArray(function(err, results){
                socket.emit('sentiment_result', {result:results[0].c_sentiment});
              });
          }
      });
  });

  socket.on('load_info', function(data){
    data = JSON.parse(data);
    conn.query("select * from client_info where c_no=?",
     data.c_no,
      function(err, results, fields){
        if(err) console.log(err);
        else{
          socket.emit('load_info', JSON.stringify(results[0]));
        }
    });
  });

  socket.on('load_food',function(data){
    data = JSON.parse(data);
      conn.query('select * from food_info where f_emo_no=?', data.f_emo_no, function(err, results, fields){
         if(err) console.log(err);
         else{
           socket.emit('load_food', JSON.stringify(results));
         }
      });
  });
   
 
  
});

/**
 * Listen on provided port, on all network interfaces.
 */

server.listen(port);
server.on('error', onError);
server.on('listening', onListening);

/**
 * Normalize a port into a number, string, or false.
 */

function normalizePort(val) {
  var port = parseInt(val, 10);

  if (isNaN(port)) {
    // named pipe
    return val;
  }

  if (port >= 0) {
    // port number
    return port;
  }

  return false;
}

/**
 * Event listener for HTTP server "error" event.
 */

function onError(error) {
  if (error.syscall !== 'listen') {
    throw error;
  }

  var bind = typeof port === 'string'
    ? 'Pipe ' + port
    : 'Port ' + port;

  // handle specific listen errors with friendly messages
  switch (error.code) {
    case 'EACCES':
      console.error(bind + ' requires elevated privileges');
      process.exit(1);
      break;
    case 'EADDRINUSE':
      console.error(bind + ' is already in use');
      process.exit(1);
      break;
    default:
      throw error;
  }
}

/**
 * Event listener for HTTP server "listening" event.
 */

function onListening() {
  var addr = server.address();
  var bind = typeof addr === 'string'
    ? 'pipe ' + addr
    : 'port ' + addr.port;
  debug('Listening on ' + bind);
}
