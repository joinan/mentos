module.exports = function(MongoClient) {

    var express = require('express');
    var router = express.Router();

    var url = 'mongodb://localhost:27017/mentos';
    var dbObj = null;
    MongoClient.connect(url, function(err, db) {
        console.log("Connected correctly to MongoDB server");
        dbObj = db;
    });

  /* GET home page. */
    router.get('/', function (req, res, next) {
        res.render('board', {name: req.session.user.c_name});
    });

    router.post('/noteProcess', function (req, res) {
        var note = dbObj.collection('mentos');
        var no = req.session.user.c_no;
        note.insert({c_no:no,c_title:req.body.title,c_content:req.body.content},function(err, result){
            if(err) res.redirect('board');
            else res.redirect('/main');
        });
    });

    return router;
}