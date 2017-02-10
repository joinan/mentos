var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
    res.render('movie',{name:req.session.user.c_name,m_emotion:req.session.user.m_emotion});
});

module.exports = router;