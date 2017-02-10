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

var MongoClient = require('mongodb').MongoClient;
var ObjectID = require('mongodb').ObjectID;

//Connection URL
var url = 'mongodb://localhost:27017/mentos';
//Use connect method to connect to the Server
var dbObj = null;
MongoClient.connect(url, function(err, db) {
    if(!err){
        dbObj = db;
    }else{
        console.log(err);
    }
//db.close();
});

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

router.get('/sentiment',function(req,res){
    var mentos = dbObj.collection('mentos');
    var senti = [0,0,0,0,0,0,0,0];
    mentos.find({c_no:req.session.user.c_no}).toArray(function(err, results){
    	for(var i =0;i<results.length; i++){
        	senti[results[i].c_sentiment]++;
		}
        res.render('sentiment',
            {
            	name	:req.session.user.c_name,
                relax	:senti[1],
                boring	:senti[2],
                happy	:senti[3],
                anger	:senti[4],
                fear	:senti[5],
                hate	:senti[6],
                depress	:senti[7],
                question:senti[0]
            });
    });

});

module.exports = router;
