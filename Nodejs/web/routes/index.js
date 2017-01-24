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

	router.get('/loginfail', function(req, res, next) {
	  res.render('loginfail');
	});

	router.post('/login',
    	passport.authenticate(
    		'local',{
    			failureRedirect: '/loginfail',
    			failureFlash: true
    		}
    	),
	    function(req, res) {
	    	req.session.user = req.user;
	        res.redirect('main');
    	}
    );

	router.get('/signin', function(req, res){
		res.render('signin');
	});

	router.post('/signin', function(req, res){
    	var user = {
        	c_id:req.body.reg_id,
        	c_pw:req.body.reg_password,
        	c_name:req.body.reg_name
        };
      	var sql = 'INSERT INTO client_info SET ?';
      	conn.query(sql, user, function(err, results){
        	if(err){
          		if(err.code == 'ER_DUP_ENTRY')
          			res.redirect('signinfail_dup');
        	} else {
          		res.redirect('login');
        	}
      	});
    });

    router.get('/signinfail_dup', function(req, res, next) {
	  res.render('signinfail_dup');
	});


	router.get('/findpw', function(req, res){
		res.render('findpw');
	});

	return router;
}