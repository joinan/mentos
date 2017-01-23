var express = require('express');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var session = require('express-session');
var MySQLStore = require('express-mysql-session')(session);
var passport = require('passport');
var LocalStrategy = require('passport-local').Strategy;

var app = express();

app.use(passport.initialize());
app.use(passport.session());

// DB 설정
var mysql = require('mysql');
var conn = mysql.createConnection({
	host	: 'localhost',
	user	: 'root',
	password: 'mentos1234',
	database: 'mentos'
});
conn.connect();

// 세션 설정
app.use(session({
	secret	: '398difELI)#%!@$053dEMv#!', // 키값
	resave	: false,
	saveUninitialized	: true,
	store 	: new MySQLStore({
		host	: 'localhost',
		port 	: 3306,
		user	: 'root',
		password: 'mentos1234',
		database: 'mentos'
	})
}));

// Passport 설정
passport.serializeUser(function(user, done) {
	console.log('serializeUser', user);
    done(null, user);
});

passport.deserializeUser(function(id, done) {
	console.log('deserializeUser', user);
    var sql = 'SELECT * FROM client_info WHERE c_id=?';
    conn.query(sql, [id], function(err, results){
    	var user = results[0];
    	if(err){
        	console.log(err);
        	done('There is no user.');
      	} else {
        	done(null, user);
      	}
    });
});

passport.use(new LocalStrategy(
    function(username, password, done){
    	var id = username;
     	var pw = password;
     	var sql = 'SELECT * FROM client_info WHERE c_id=?';
      	conn.query(sql, [id], function(err, results){
       		if(err){
          		return done('There is no user.');
        	}
        	var user = results[0];
        	if(pw === user.c_pw){
        		console.log('LocalStrategy', user);
            	done(null, user);
          	} else {
            	done(null, false);
          	}
      	});
    }
));

var index = require('./routes/index')(passport, conn);
// var signin = require('./routes/signin');
// var login = require('./routes/login');
// var findpw = require('./routes/findpw');
var main = require('./routes/main')(passport, app);
var board = require('./routes/board');
var movie = require('./routes/movie');
var food = require('./routes/food');
var center = require('./routes/center');
var mypage = require('./routes/mypage');



// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

// uncomment after placing your favicon in /public
//app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')));
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', index);
app.use('/main', main);
app.use('/board', board);
// app.use('/signin', signin);
// app.use('/login', login);
// app.use('/findpw',findpw);
app.use('/movie', movie);
app.use('/food', food);
app.use('/center', center);
app.use('/mypage', mypage);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  var err = new Error('Not Found');
  err.status = 404;
  next(err);
});

// error handler
// app.use(function(err, req, res, next) {
//   // set locals, only providing error in development
//   res.locals.message = err.message;
//   res.locals.error = req.app.get('env') === 'development' ? err : {};

//   // render the error page
//   res.status(err.status || 500);
//   res.render('error');
// });

module.exports = app;
