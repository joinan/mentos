var express = require('express');
var router = express.Router();
var flag = 0;
/* GET main page. */
router.get('/', function(req, res){
	if(!req.session.user){
		res.redirect('/login');
	}else{
		flag++;
		res.render('main', {name:req.session.user.c_name, c_no:req.session.user.c_no, flag:flag});
	}
});

module.exports = router;
