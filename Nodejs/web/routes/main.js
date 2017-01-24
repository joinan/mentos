module.exports = function(passport, app) {

	var express = require('express');
	var router = express.Router();

	app.use(passport.session());
	/* GET home page. */
	router.get('/', function(req, res, next) {
		console.log('여기는 메인입니다');
		console.log(req.user);
		res.render('main');
	});
	return router;
}