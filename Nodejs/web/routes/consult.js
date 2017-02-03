module.exports = function(passport, app, conn) {

	var express = require('express');
	var router = express.Router();

	/* GET home page. */


	app.get('/consult',function(req,res){
		conn.query('select * from consult_info  order by date desc', function(err, results, fields) {
			res.render('consult', {
				name	 : req.session.user.c_name,
				articles : results
			});
		});
			});

	app.get('/consult/:no', function(req, res) {
		conn.query('select * from consult_info where no=?', req.params.no, function(
				err, results, fields) {
				if(results.length>0){
					res.render('consultdetail',{article:results[0],name	 : req.session.user.c_name,});
				}else{
					res.redirect('/');
				}
		});
	});
	return router;
}
