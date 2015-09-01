## WEBVIEW / DISPLAY IMAGE

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":1,
		"url":"http://192.168.1.11:8000/images/hello.png",
		"x":-1400,
		"y":0,
		"width":412,
		"height":603
	}' 


## WEBVIEW / EXTERNAL_URL

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":10,
		"url":"http://google.es"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":10,
		"url":"http://josejuansanchez.org"
	}' 


### WEBVIEW / JAVASCRIPT 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json"  \
	-X POST \
	-d '
	{
		"type":10,
		"url":"http://192.168.1.11:8000/javascript/doc_lastmodified.html"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":10,
		"url":"http://192.168.1.11:8000/javascript/doc_open.html"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":10,
		"url":"http://192.168.1.11:8000/javascript/events_body_onload.html"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":10,
		"url":"http://192.168.1.11:8000/javascript/events_img_onload.html"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":10,
		"url":"http://192.168.1.11:8000/javascript/screen.html"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":10,
		"url":"http://192.168.1.11:8000/javascript/devicepixelratio.html"
	}' 


### WEBVIEW / VIDEO

* https://developer.mozilla.org/en-US/docs/Web/API/HTMLMediaElement

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":10,
		"url":"http://192.168.1.11:8000/video/videotest.html"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":10,
		"url":"http://192.168.1.11:8000/video/videotest-02.html"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":10,
		"url":"http://192.168.1.11:8000/video/video_javascript.html"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":10,
		"url":"http://192.168.1.11:8000/video/dash_player.html"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":10,
		"url":"http://192.168.1.11:8000/video/vlc.html"
	}' 


### VIDEO (VideoView)

* Video samples: http://download.openbricks.org/sample/H264/

curl http://192.168.1.11:5000/set
	-H "Content-Type: application/json" 
	-X POST 
	-d '
	{
		"type":201,
		"url":"http://download.openbricks.org/sample/H264/big_buck_bunny_480p_H264_AAC_25fps_1800K.MP4"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":201,
		"url":"http://techslides.com/demos/sample-videos/small.mp4"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":201,
		"url":"http://techslides.com/demos/sample-videos/small.webm"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":201,
		"url":"http://download.wavetlan.com/SVV/Media/HTTP/MP4/ConvertedFiles/MediaCoder/MediaCoder_test1_1m9s_AVC_VBR_256kbps_640x480_24fps_MPEG2Layer3_CBR_160kbps_Stereo_22050Hz.mp4
"
}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":201,
		"url":"http://sample-videos.com/video/mp4/720/big_buck_bunny_720p_50mb.mp4"
	}' 


### VIDEO (ExoPlayer)

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":1100,
		"url":"http://techslides.com/demos/sample-videos/small.mp4"
	}' 


### VIDEO (ExoMedia)

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":1101,
		"url":"http://techslides.com/demos/sample-videos/small.mp4"
	}' 

curl http://192.168.1.11:5000/set \
	- H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":1101,
		"url":"http://sample-videos.com/video/mp4/720/big_buck_bunny_720p_50mb.mp4"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":1101,
		"url":"https://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/bipbop_16x9_variant.m3u8"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":1101,
		"url":"https://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/bipbop_4x3_variant.m3u8"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":1101,
		"url":"http://demos.webmproject.org/exoplayer/glass_vp9_vorbis.webm"
	}' 


Use this samples:
* https://github.com/google/ExoPlayer/blob/master/demo/src/main/java/com/google/android/exoplayer/demo/Samples.java


### AUDIO (MediaPlayer)

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":200,
		"url":"http://creativecommons.lt/cloud/pub/sutemos/torrent/mp3/VA%20:%20Intelligent%20Toys:%20We%20Make%20Music%20(Sutemos027)/CD%202%20-%20Make/02%20Soulsonic%20-%20No.mp3"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":200,
		"url":"http://192.168.1.11:8000/audio/baby_mozart.mp3"
	}' 


## WEBVIEW / ROTATION

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":100,
		"rotation":0
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":100,
		"rotation":45.0
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":100,
		"rotation":90.0
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":100,
		"rotation":135.0
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":100,
		"rotation":180.0
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":100,
		"rotation":225.0
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":100,
		"rotation":270.0
	}' 


## WEBVIEW / ZOOMBY

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":101,
		"zoomFactor":25
	}' 

## WEBVIEW / ZOOMIN

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '{"type":102}' 

## WEBVIEW / ZOOMOUT

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '{"type":103}' 


## ADB COMMAND

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":300,
		"command":"ls"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":300,
		"command":"adb logcat"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":300,
		"command":"adb shell am start -n com.whatsapp/com.whatsapp.Main"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type": 300,
		"command":"am start -n com.android.chrome/com.google.android.apps.chrome.Main"
	}' 


## TEXT TO SPEECH

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":1200,
		"text":"Hola"
	}' 


Android Shell Commands:
https://github.com/jackpal/Android-Terminal-Emulator/wiki/Android-Shell-Command-Reference
----------------------
id
date
df
screenrecord /sdcard/demo.mp4


## LOAD_IMAGE

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":400,
		"url":"http://i.imgur.com/DvpvklR.png"
	}' 

### Transformations

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":400,
		"url":"http://i.imgur.com/DvpvklR.png",
		"transformation":
		{
			"name":"CropType",
			"width":300,
			"height":200
		}
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":400,
		"url":"http://i.imgur.com/DvpvklR.png",
		"transformation":
		{
			"name":"Pixel",
			"pixel":80
		}
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":400,
		"url":"http://i.imgur.com/DvpvklR.png",
		"transformation":
		{
			"name":"Sepia"
		}
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":400,
		"url":"http://i.imgur.com/DvpvklR.png",
		"transformation":
		{
			"name":"CropCircle"
		}
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":400,
		"url":"http://upload.wikimedia.org/wikipedia/commons/f/f3/Arrecife_de_las_Sirenas_2_-_Almer%C3%ADa_%282569433323%29.jpg"
	}' 

curl http://192.168.1.11:5000/set
	-H "Content-Type: application/json" 
	-X POST 
	-d '
	{
		"type":400,
		"url":"http://upload.wikimedia.org/wikipedia/commons/f/f3/Arrecife_de_las_Sirenas_2_-_Almer%C3%ADa_%282569433323%29.jpg",
		"x":0,
		"y":0,
		"width":20,
		"height":200
	}' 


## TAKE PICTURE

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '{"type":500}' 

## CHART

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '{"type":600}' 

## SURFACEVIEW

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '{"type":700}' 

## SURFACEVIEW_SET_BACKGROUND_COLOR

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '{
			"type":701,
			"r": 125,
			"g": 125,
			"b": 125
		}' 


## WEBVIEW MONITOR

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":900, 
		"label":"Temperatura", 
		"value": "44.31", 
		"timestamp":"Viernes, 26 Junio, 19:45:00"
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":900, 
		"label":"Temperatura", 
		"value": "24.67", 
		"timestamp":"Viernes, 26 Junio, 19:45:00"
	}' 

## VIBRATE

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":1000, 
		"milliseconds":100
	}' 


## UI
### BUTTON

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d'
	{
		"type":2000,
		"text":"Prueba",
		"x":10,
		"y":500
	}' 

### SEEKBAR - HTTP

The HTTP method used is POST

* Mandatory fields:
  - type
  - labels
  - action.connection
  	* if action.connection == "http"
  		- uris
  	* if action.connection == "mqtt"
  		- uris
  		- topic

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":2001,
		"labels": ["Volumne"],
		"action": {
			"connection": "http", 
			"uris": ["http://192.168.1.13:3000"]
		}
	}' 


curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":2001,
		"labels": ["Left Servo", "Right Servo"],
		"max_values": [180, 180],
		"initial_values": [90, 90],
		"action": {
			"connection": "http", 
			"uris": ["http://192.168.1.13:3000"]
		}
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":2001,
		"labels": ["R", "G", "B"],
		"max_values": [255, 255, 255],
		"action": {
			"connection": "http", 
			"uris": ["http://192.168.1.13:3000"]
		}
	}' 


curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":2001,
		"labels": ["A", "B", "C", "D", "E", "F"],
		"max_values": [255, 255, 255, 255, 255, 255],
		"action": {
			"connection": "http", 
			"uris": ["http://192.168.1.13:3000"]
		}
	}' 


curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":2001,
		"labels": ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"],
		"max_values": [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255],
		"action": {
			"connection": "http", 
			"uris": ["http://192.168.1.13:3000"]
		}
	}' 


### SEEKBAR - SERIAL

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":2001,
		"labels": ["light"],
		"action": {
			"connection": "serial"
		}
	}' 

// If the "baudrate" tag is not present in the message, 
// then a baud rate of 9600 bit/s is used by default.
// Supported baud rates are 300, 600, 1200, 2400, 4800, 9600, 
// 14400, 19200, 28800, 31250, 38400, 57600, and 115200.
//
// The above message will generate the next json response:
// {"light": 120}

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":2001,
		"labels": ["light"],
		"action": {
			"connection": "serial",
			"baudrate": 115200
		}
	}' 


curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":2001,
		"labels": ["r", "g", "b"],
		"max_values": [255, 255, 255],
		"action": {
			"connection": "serial",
			"baudrate": 115200
		}
	}' 

// The above message will generate the next json response:
// {"r": 120, "g": 2, "b": 34}

### SEEKBAR - MQTT

IMPORTANT NOTE: MqttClient only accept tcp, ssl or local as uri.

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":2001,
		"labels": ["light"],
		"action": {
			"connection": "mqtt",
			"uris": ["tcp://test.mosquitto.org"],
			"topics": ["my-topic"]
		}
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":2001,
		"labels": ["R", "G", "B"],
		"max_values": [255, 255, 255],
		"action": {
			"connection": "mqtt",
			"uris": ["tcp://test.mosquitto.org"],
			"topics": ["my-topic"]
		}
	}' 


### EXAMPLE OF USE WITH SEEKBAR

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":1,
		"url":"http://192.168.1.12:8000/sun.jpg",
		"x":0,
		"y":0,
		"width":412,
		"height":603
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":2,
		"x":-200,
		"y":0
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":0,
		"x":0,
		"y":0
	}' 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"x":0,
		"y":300
	}' 

curl http://192.168.1.17:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":2001,
		"labels": ["x", "y"],
		"min_values": [-500, -500],
		"max_values": [600, 600],
		"initial_values": [0, 0],
		"action": {
			"connection": "http",
			"uris": ["http://192.168.1.11:5000/set"]
		}
	}' 

### ACCELEROMETER 

curl http://192.168.1.11:5000/set \
	-H "Content-Type: application/json" \
	-X POST \
	-d '
	{
		"type":2002,
		"labels": ["r", "g", "b"],
		"action": {
			"connection": "mqtt",
			"uris": ["tcp://test.mosquitto.org"],
			"topics": ["my-topic"]
		}
	}' 

