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

	router.post('/login',
		passport.authenticate(
			'local',
			{
				successRedirect	: '/main',
				failureRedirect	: '/login',
				failureFlash	: false 
			}
		)
	);

	router.get('/signin', function(req, res){
		res.render('signin');
	});

	router.get('/findpw', function(req, res){
		res.render('findpw');
	});

	return router;
}