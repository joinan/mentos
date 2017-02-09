var express = require('express');
var router = express.Router();
var mysql = require('mysql');
var conn = mysql.createConnection({
  host  : 'localhost', // 주소
  user  : 'root', // 사용자
  password: 'root', // 비밀번호
  database: 'mentos' // db이름
});
// mysql 연결
conn.connect();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('mypage', {name : req.session.user.c_name});
});

router.get('/update', function(req, res, next){
	res.render('update', {c_no:req.session.user.c_no, name : req.session.user.c_name});
});

router.post('/update/updateProcess', function(req, res, next){
		var c_no = req.body.c_no;
		var c_email = req.body.c_email;
		var c_name = req.body.c_name;
		var c_age = Number(req.body.c_age);
		var c_nickname = req.body.c_nickname;
		var c_gender = req.body.c_gender;
		var c_question = Number(req.body.c_question);
		var c_answer = req.body.c_answer;
		var c_doc = Number(req.body.c_doc);
		var sql = 'update client_info set c_email=?, c_name=?, c_nickname=?, c_gender=?, c_age=?, c_question=?, c_answer=?, c_doc=? where c_no=?';
		conn.query(sql,[c_email, c_name, c_nickname, c_gender, c_age, c_question, c_answer, c_doc, c_no], function(err, results){
			if(err){
				console.log('update err');
				console.log(err);
				res.redirect('/mypage/update');
			}else{
				user = results[0];
				if(!user)
					res.jsonp({msg:'수정되었습니다.'});
			}
		});
	});

module.exports = router;
