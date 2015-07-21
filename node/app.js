var express = require('express');
var app = express();
var bodyParser = require('body-parser');

// support json encoded bodies
app.use(bodyParser.json()); 
// support encoded bodies
app.use(bodyParser.urlencoded({ extended: true })); 


// accept GET request on the homepage
app.get('/', function (req, res) {
  res.json('Hello World');
  console.log('Hello World');
})

// accept POST request on the homepage
app.post('/', function (req, res) {
  res.json('Got a POST request');
  console.log('Got a POST request: ');
  console.log('R: ' + req.body.R);
  console.log('G: ' + req.body.G);
  console.log('B: ' + req.body.B);
});

// accept PUT request at /user
app.put('/user', function (req, res) {
  res.json('Got a PUT request at /user');
  console.log('Got a PUT request at /user');
});

// accept DELETE request at /user
app.delete('/user', function (req, res) {
  res.json('Got a DELETE request at /user');
  console.log('Got a DELETE request at /user');
});


app.listen(3000);
console.log('Server running...');