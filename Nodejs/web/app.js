// 사용하는 모듈 정의
var express = require('express');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var session = require('express-session');
var MySQLStore = require('express-mysql-session')(session);
var passport = require('passport');
var flash = require('connect-flash');
var LocalStrategy = require('passport-local').Strategy;
var MongoClient = require('mongodb').MongoClient;
var R = require('r-script');

var app = express();

// passport를 express에 연결
app.use(passport.initialize());

// passport를 session에 연결
app.use(passport.session());

app.use(flash());

// DB 설정
var mysql = require('mysql');
// mysql 연결 설정
var conn = mysql.createConnection({
	host	: 'localhost', // 주소
	user	: 'root', // 사용자
	password: 'mentos1234', // 비밀번호
	database: 'mentos' // db이름
});
// mysql 연결
conn.connect();



// 세션 설정
app.use(session({
	secret	: '398difELI)#%!@$053dEMv#!', // 키값
	resave	: false, // 세션 아이디를 접속할때마다 발급할지 결정
	saveUninitialized	: true, // 세션을 실제로 사용할 때 세션아이디를 발급해줄지
	store 	: new MySQLStore({ // 세션에 db를 연결
		host	: 'localhost', // db주소
		port 	: 3306, // db포트
		user	: 'root', // 사용자
		password: 'mentos1234', // 비밀번호
		database: 'mentos' // db이름
	})
}));

// Passport 설정
// serializeUser : 세션에 처음 접속할 때 실행
passport.serializeUser(function(user, done) { // user객체를 받아서
	console.log('Serialize');
	done(null, user); // user객체를 세션에 보낸다.
});

// deserializeUser : 세션에 재차 접속할 때 실행
// passport.deserializeUser(function(id, done) { // id값을 받아서
//     var sql = 'SELECT * FROM client_info WHERE c_email=?'; // sql문 생성해서
//     conn.query(sql, [id], function(err, results){ // 결과를 results로 받고
//     	var user = results[0]; // user 객체로 결과를 받는다
//     	if(err){ // 에러가 있으면
//         	console.log(err); // 에러 출력하고
//         	done('There is no user.'); // db에서 해당 id를 찾을 수 없음
//       	} else {
//         	done(null, user); // 에러가 없다면 user객체를 세션에 보낸다
//       	}
//     });
// });
passport.deserializeUser(function(user,done){
	console.log('deserialize');
	console.log(user);
	done(null,user);
});

// 세션에 연결하기 위한 전략 설정
passport.use(new LocalStrategy( // 로컬에서 로그인 처리하기 위한 전략
  function(username, password, done){ // 페이지에서 username과 password를 받아서
    var email = username; // id와 pw에 넣어준다
    var pw = password;
    var sql = 'SELECT * FROM client_info WHERE c_email=?'; // sql문 만들어서
    console.log('여기까지는 실행');
      conn.query(sql, [email], function(err, results){ // 결과를 results로 받고
        if(err){ // 에러가 있으면
          return done('There is no user.'); // db에서 id를 찾을 수 없음
        }
        var user = results[0];
        if(!user) {
          return done(null, false);
        }
        	 // user객체에 결과값을 넣고
        if(pw === user.c_pw){ // 받은 pw가 db의 c_pw와 같으면
          done(null, user); // user객체를 성공시 사용
        } else {
          done(null, false); // 실패시 아무것도 하지 않는다.
        }
      });
    }
));

var index = require('./routes/index')(passport, conn);
var main = require('./routes/main')(MongoClient);
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

// error handler 에러가 발생하면 처리해주는데 적용시키면 에러가 발생했는지 구별이 안감
// app.use(function(err, req, res, next) {
//   // set locals, only providing error in development
//   res.locals.message = err.message;
//   res.locals.error = req.app.get('env') === 'development' ? err : {};

//   // render the error page
//   res.status(err.status || 500);
//   res.render('error');
// });

module.exports = app;
