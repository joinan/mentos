var express = require('express');
var router = express.Router();
var mysql      = require('mysql');
var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',
  password : 'root',
  database : 'didimdol'
});
/* GET home page. */
router.get('/', function(req, res, next) {
	connection.query('select * from movie', function (error, results, fields) {
		  if (error) console.log(error);
		  else res.send(JSON.stringify(results));
	});
});

router.post('/', function(req, res, next) {
	connection.query('INSERT INTO movie SET ?', 
			{
				no: Number(req.body.no),
				title: req.body.title,
				created: req.body.created, 
				country:req.body.country, 
				genre:req.body.city, 
				director:req.body.director
			}, function (error, result, fields) {
					if (error) throw error;
					  //console.log(result.insertId);
					else res.send(JSON.stringify(result));
	});  
});

router.put('/', function(req, res, next) {
	connection.query("delete from movie",
			function(err,result){
		var movies = JSON.parse(req.body.movies);
		for(var i = 0; i < movies.length; i++){
			connection.query("insert into movie set ?",
					movies[i], 
					function(err, result){
			});
		}
		if(err) res.send(err);
		else res.send(JSON.stringify(result));
	});
});
router.delete('/', function(req, res, next) {
	connection.query('delete from movie', function (error, results, fields) {
					if (error) throw error;
					  //console.log(result.insertId);
					else res.send(JSON.stringify(results));
	});
});

module.exports = router;
