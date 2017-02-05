var express = require('express');
var router = express.Router();

/* GET main page. */
router.get('/', function(req, res){
	if(!req.session.user){
		res.redirect('/login');
	}else{
		res.render('main', {name:req.session.user.c_name, c_no:req.session.user.c_no})
	}
});

module.exports = router;
