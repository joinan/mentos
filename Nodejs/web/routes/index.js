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

	router.post('/loginProcess', function(req, res, next){
		var email = req.body.username;
		var password = req.body.password;
		var user;
		console.log('eeeeeeeeee',email);
		console.log('pppppppppp',password);
		var sql = 'SELECT * FROM client_info WHERE c_email=?';
		conn.query(sql, [email], function(err, results){
			if(err){
				console.log('@@@@@@@@@@@@@@',err.code);
				res.redirect('/login');
			}else{
				console.log('!!!!!!!!!!!!!',results[0]);
				user = results[0];
				console.log('!!!!!!!!!!!!!',user);
				if(!user)
					res.jsonp({msg:'이메일이 없습니다.'});
				else {
					if(password == user.c_pw){
						console.log('ㅉㅉㅉㅉ쩡답ㅃㅃㅃㅃㅃㅃ');
						req.session.name = user.c_name;
						res.jsonp({msg:'환영합니다.'});
					}else{
						res.jsonp({msg:'비밀번호가 틀립니다.'});
					}
				}
			}
		});
	});

	router.post('/login', function(req, res){
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
