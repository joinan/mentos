module.exports = function(passport, conn){
	var sizeof = require('object-sizeof');
	var express = require('express');
	var router = express.Router();

	/* GET home page. */
	router.get('/', function(req, res, next) {
	  res.render('index', { title: 'Mentos' });
	});

	router.get('/login', function(req, res, next) {
	  res.render('login');
	});

	router.get('/loginProcess',ensureAuthenticated, function(req,res){
		res.send(req.user);
	});


	router.post('/loginProcess', function(req, res, next){
		var email = req.body.username;
		var password = req.body.password;
		var user;
		var sql = 'SELECT * FROM client_info WHERE c_email=?';
		conn.query(sql, [email], function(err, results){
			if(err){
				res.redirect('/login');
			}else{
				user = results[0];
				if(!user)
					res.jsonp({msg:'이메일이 없습니다.'});
				else {
					if(password == user.c_pw){
						res.jsonp({msg:'환영합니다.'});
					}else{
						res.jsonp({msg:'비밀번호가 틀립니다.'});
					}
				}
			}
		});
	});

	router.post('/login',
		passport.authenticate('local',{
			failureRedirect:'/login',
			failureFlash: true}),
			function(req, res){
				req.session.user = req.user;
				res.redirect('main');
	});
	// router.post('/login',function(req, res) {
	// 	var email = req.body.lg_username;
	// 	var password = req.body.lg_password;
	// 	var user;
	// 	console.log('eeeeeeeeee',email);
	// 	console.log('pppppppppp',password);
	// 	var sql = 'SELECT * FROM client_info WHERE c_email=?';
	// 	conn.query(sql, [email], function(err, results){
	// 		if(err){
	// 			console.log('@@@@@@@@@@@@@@',err.code);
	// 			res.redirect('/');
	// 		}else{
	// 			console.log('!!!!!!!!!!!!!',results[0]);
	// 			user = results[0];
	// 			console.log('!!!!!!!!!!!!!',user);
	// 			if(!user)
	// 				res.render('login',{result:'failEmail', msg:'이메일이 틀립니다.'})
	// 			else {
	// 				if(password == user.c_pw){
	// 					req.session.name = user.c_name;
	// 					res.redirect('main',{result:'success', name:user.c_name, msg:'환영합니다'});
	// 				}else{
	// 					res.render('login',{result:'failPassword', msg:'비밀번호가 틀립니다.'})
	// 				}
	// 			}
	// 		}
	// 	});
  // });

    router.get('/logout', function(req, res) {
		req.session.destroy();
		res.clearCookie('sid');
		res.redirect('login');
	});

	router.get('/signin', function(req, res){
		res.render('signin');
	});

	router.post('/duplEmail', function(req, res, next){
		var email = req.body.reg_email;
		console.log('@@@@@$$$$$$$$$$$$$$$$$$',email);
		var sql = 'SELECT * FROM client_info WHERE c_email=?';
		conn.query(sql, [email], function(err, results){
			if(err){
				res.jsonp({msg:'ERROR'});
			}else{
				user = results[0];
				if(sizeof(user)==0) {
					console.log('!@!@!@!@!@',user);
					res.jsonp({result:true, msg:'사용가능합니다.'});
				}
				else
					res.jsonp({result:false, msg:'이메일이 중복됩니다'});
			}
		});
	});

	router.post('/signin', function(req, res){
		res.redirect('login');
	});

	router.post('/signinProcess', function(req, res){
      	var sql = 'INSERT INTO client_info set ?';
      	conn.query(sql, {
			c_email		:req.body.reg_email,
			c_pw		:req.body.reg_password,
			c_name		:req.body.reg_name,
			c_nickname	:req.body.reg_nickname,
			c_gender	:req.body.reg_gender,
			c_age	:req.body.reg_age,
			c_question	:req.body.reg_question,
			c_answer	:req.body.reg_answer
		}, function(err, results){
        	if(err){
          		res.jsonp({msg:'회원가입에 실패했습니다.'})
        	} else {
          		res.jsonp({msg:'회원가입에 성공했습니다.'});
        	}
      	});
    });

    // router.get('/signinfail_dup', function(req, res, next) {
	//   res.render('signinfail_dup');
	// });
	//
	// router.get('/signinfail_bad_field', function(req, res, next) {
	//   res.render('signinfail_bad_field');
	// });


	router.get('/findpw', function(req, res){
		res.render('findpw');
	});

	function ensureAuthenticated(req, res, next){
		if(req.isAuthenticated()) { return next();}
		res.redirect('/login');
	}

	return router;
}
