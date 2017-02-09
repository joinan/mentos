var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('food',{name:req.session.user.c_name,f_emotion:req.session.user.f_emotion});
});

module.exports = router;