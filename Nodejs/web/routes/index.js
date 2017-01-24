module.exports = function(passport, conn){

	var express = require('express');
	var router = express.Router();

	/* GET home page. */
	router.get('/', function(req, res, next) {
	  res.render('index', { title: 'Mentos' });
	});

	router.get('/login', function(req, res, next) {
	  res.render('login');
	});

	// 다른 방법
	// router.post('/login', function(req, res, next) {
	// 	passport.authenticate('local', function(err, user, info) {
	// 		if (err) { return next(err); }
	// 	    if (!user) { return res.redirect('/'); }

	// 	    // req / res held in closure
	// 	    req.logIn(user, function(err) {
	// 	    	if (err) { return next(err); }
	// 	    });
	// 	})(req, res, next);
	// 	res.render('main');
	// });

	// 기본 방법
	// router.post('/login',
	// 	passport.authenticate(
	// 		'local',
	// 		{
	// 			successRedirect	: '/main',
	// 			failureRedirect	: '/login',
	// 			failureFlash	: false 
	// 		}
	// 	)
	// );

	router.post('/login',
    	passport.authenticate(
    		'local',{
    			failureRedirect: '/login',
    			failureFlash: true
    		}
    	),
	    function(req, res) {
	    	console.log('로그인 페이지 입니다 객체는 :',req.user);
	    	req.session.user = req.user;
	    	console.log('로그인 페이지 입니다 세션 객체는 :',req.session.user);
	        res.redirect('main');
    	}
    );



	router.get('/signin', function(req, res){
		res.render('signin');
	});

	router.get('/findpw', function(req, res){
		res.render('findpw');
	});

	return router;
}