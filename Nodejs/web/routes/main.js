module.exports = function(passport, app) {

	var express = require('express');
	var router = express.Router();

	app.use(passport.session());
	/* GET home page. */
	router.get('/', function(req, res, next) {
		res.render('main');
	});
	return router;
}