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

    router.get('/logout', function(req, res) {
		req.session.destroy();
		res.clearCookie('sid');
		res.redirect('login');
	});

	router.get('/signin', function(req, res){
		res.render('signin');
	});

	router.post('/signin', function(req, res){
        console.log('!&@$*(!^&@$*(!^@&$(!@^&(*',req.body.reg_age);
      	var sql = 'INSERT INTO client_info (c_email, c_pw, c_name, c_nickname, c_gender, c_age) VALUES (?,?,?,?,?,?)';
      	conn.query(sql, [req.body.reg_email,req.body.reg_password,req.body.reg_name,req.body.reg_nickname, req.body.reg_gender, req.body.reg_age], function(err, results){
        	if(err){
          		if(err.code == 'ER_DUP_ENTRY')
          			res.redirect('signinfail_dup');
          		else if(err.code == 'ER_BAD_FIELD_ERROR')
          			res.redirect('signinfail_bad_field');
          		else {
          			res.redirect('signin');
          		}
        	} else {
          		res.redirect('login');
        	}
      	});
    });

    router.get('/signinfail_dup', function(req, res, next) {
	  res.render('signinfail_dup');
	});

	router.get('/signinfail_bad_field', function(req, res, next) {
	  res.render('signinfail_bad_field');
	});


	router.get('/findpw', function(req, res){
		res.render('findpw');
	});

	return router;
}