module.exports = function(passport, app) {

	// app.use(passport.initialize());
	// app.use(passport.session());


	var express = require('express');
	var router = express.Router();

	app.use(passport.session());
	/* GET home page. */

	router.get('/', function(req, res) {
		console.log('여기는 메인입니다');
		console.log('리퀘스트 유저값은 : ',req.session.user);
		res.render('main',{name : req.session.user.c_id});
	});


	// router.get('/', function(req, res, next) {
	// 	function checkAuthentication(req,res,next){
	// 	    if(req.isAuthenticated()){
	// 	        //if user is looged in, req.isAuthenticated() will return true 
	// 	        next();
	// 	    } else{
	// 	        res.redirect("login");
	// 	    }
	// 	}
	// 	console.log('여기는 메인입니다');
	// 	console.log('리퀘스트 유저값은 : ',req.user);
	// 	res.render('main');
	// });

	return router;
}