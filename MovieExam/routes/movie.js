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
	connection.query('select * from movie where no=?',req.query.no, function (error, result, fields) {
		  if (error) console.log(error);
		  else res.send(JSON.stringify(result));
	});
});

router.put('/', function(req, res, next) {
	connection.query('update movie SET ? where no=?', 
			[{
				title: req.body.title,
				created: req.body.created, 
				country:req.body.country, 
				genre:req.body.city, 
				director:req.body.director
			},Number(req.body.no)], function (error, results, fields) {
					if (error) throw error;
					  //console.log(result.insertId);
					else res.send(JSON.stringify(results));
	});
});

router.delete('/', function(req, res, next) {
	connection.query('delete from movie where no=?',Number(req.body.no), function (error, results, fields) {
					if (error) throw error;
					  //console.log(result.insertId);
					else res.send(JSON.stringigy(results));
	});
});

module.exports = router;
