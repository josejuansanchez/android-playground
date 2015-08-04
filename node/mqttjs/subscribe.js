var mqtt    = require('mqtt');
var client  = mqtt.connect('mqtt://test.mosquitto.org');
var topic   = 'my-topic'

client.subscribe(topic);

client.on('message', function (topic, message) {
  console.log(message.toString());
});