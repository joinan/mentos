module.exports = function(passport, app) {

	// app.use(passport.initialize());
	// app.use(passport.session());


	var express = require('express');
	var router = express.Router();

	app.use(passport.session());
	/* GET home page. */

	router.get('/', function(req, res) {
		res.render('main',{name : req.session.user.c_name});
	});

	router.get('/logout', function(req, res) {
		req.session.destory();
		res.clearCookie('sid');
		res.redirect('/login');
	});


	return router;
}