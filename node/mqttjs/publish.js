var mqtt    = require('mqtt');
var client  = mqtt.connect('mqtt://test.mosquitto.org');
var topic   = 'my-topic'
var message = 'Hello mqtt'

client.on('connect', function () {
  client.publish(topic, message);
  client.end()
});
