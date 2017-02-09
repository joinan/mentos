var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('food',{f_emotion:req.session.user.f_emotion});
});

module.exports = router;