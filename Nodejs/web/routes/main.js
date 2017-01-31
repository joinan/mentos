module.exports = function(passport, app) {

	// app.use(passport.initialize());
	// app.use(passport.session());


	var express = require('express');
	var router = express.Router();

	/* GET home page. */

	router.get('/', function(req, res) {
		if(!req.session.user)
			res.redirect('login');
		res.render('main',{name : req.session.user.c_name});
	});

	// router.get('/',
	// 	passport.authenticate('local',{
	// 		failureRedirect:'/login',
	// 		failureFlash: true}),
	// 		function(req, res){
	// 			res.render('main',{name : req.user.c_name});
	// });


	return router;
}
