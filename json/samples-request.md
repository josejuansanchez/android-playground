## How to start a local server on my machine

python -m SimpleHTTPServer 8000

---

## TYPE 0 - IMAGE_PARAMS
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"http://192.168.1.11:8000/images/hello.png","x":-1400,"y":0,"width":412,"height":603}' http://192.168.1.102:5000/set


// TYPE 1 - EXTERNAL_URL
curl -H "Content-Type: application/json" -X POST -d '{"type":1,"url":"http://google.es"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":1,"url":"http://josejuansanchez.org"}' http://192.168.1.102:5000/set


### JAVASCRIPT 
curl -H "Content-Type: application/json" -X POST -d '{"type":1,"url":"http://192.168.1.11:8000/javascript/doc_lastmodified.html"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":1,"url":"http://192.168.1.11:8000/javascript/doc_open.html"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":1,"url":"http://192.168.1.11:8000/javascript/events_body_onload.html"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":1,"url":"http://192.168.1.11:8000/javascript/events_img_onload.html"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":1,"url":"http://192.168.1.11:8000/javascript/screen.html"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":1,"url":"http://192.168.1.11:8000/javascript/devicepixelratio.html"}' http://192.168.1.102:5000/set


### VIDEO
* https://developer.mozilla.org/en-US/docs/Web/API/HTMLMediaElement

curl -H "Content-Type: application/json" -X POST -d '{"type":1,"url":"http://192.168.1.11:8000/video/videotest.html"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":1,"url":"http://192.168.1.11:8000/video/videotest-02.html"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":1,"url":"http://192.168.1.11:8000/video/video_javascript.html"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":1,"url":"http://192.168.1.11:8000/video/dash_player.html"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":1,"url":"http://192.168.1.11:8000/video/vlc.html"}' http://192.168.1.102:5000/set


### VIDEO (VideoView)

* Video samples: http://download.openbricks.org/sample/H264/

curl -H "Content-Type: application/json" -X POST -d '{"type":201,"url":"http://download.openbricks.org/sample/H264/big_buck_bunny_480p_H264_AAC_25fps_1800K.MP4"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":201,"url":"http://techslides.com/demos/sample-videos/small.mp4"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":201,"url":"http://techslides.com/demos/sample-videos/small.webm"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":201,"url":"http://download.wavetlan.com/SVV/Media/HTTP/MP4/ConvertedFiles/MediaCoder/MediaCoder_test1_1m9s_AVC_VBR_256kbps_640x480_24fps_MPEG2Layer3_CBR_160kbps_Stereo_22050Hz.mp4
"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":201,"url":"http://sample-videos.com/video/mp4/720/big_buck_bunny_720p_50mb.mp4"}' http://192.168.1.102:5000/set


### VIDEO (ExoPlayer)

curl -H "Content-Type: application/json" -X POST -d '{"type":1100,"url":"http://techslides.com/demos/sample-videos/small.mp4"}' http://192.168.1.102:5000/set


### VIDEO (ExoMedia)

curl -H "Content-Type: application/json" -X POST -d '{"type":1101,"url":"http://techslides.com/demos/sample-videos/small.mp4"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":1101,"url":"http://sample-videos.com/video/mp4/720/big_buck_bunny_720p_50mb.mp4"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":1101,"url":"https://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/bipbop_16x9_variant.m3u8"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":1101,"url":"https://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/bipbop_4x3_variant.m3u8"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":1101,"url":"http://demos.webmproject.org/exoplayer/glass_vp9_vorbis.webm"}' http://192.168.1.102:5000/set


Use this samples:
* https://github.com/google/ExoPlayer/blob/master/demo/src/main/java/com/google/android/exoplayer/demo/Samples.java


### AUDIO (MediaPlayer)
curl -H "Content-Type: application/json" -X POST -d '{"type":200,"url":"http://creativecommons.lt/cloud/pub/sutemos/torrent/mp3/VA%20:%20Intelligent%20Toys:%20We%20Make%20Music%20(Sutemos027)/CD%202%20-%20Make/02%20Soulsonic%20-%20No.mp3"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":200,"url":"http://192.168.1.11:8000/audio/baby_mozart.mp3"}' http://192.168.1.102:5000/set


// TYPE 100 - ROTATION
curl -H "Content-Type: application/json" -X POST -d '{"type":100,"rotation":0}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":100,"rotation":45.0}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":100,"rotation":90.0}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":100,"rotation":135.0}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":100,"rotation":180.0}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":100,"rotation":225.0}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":100,"rotation":270.0}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":100,"rotation":315.0}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":100,"rotation":360.0}' http://192.168.1.102:5000/set

// TYPE 101 - ZOOMBY
curl -H "Content-Type: application/json" -X POST -d '{"type":101,"zoomFactor":25}' http://192.168.1.102:5000/set

// TYPE 102 - ZOOMIN
curl -H "Content-Type: application/json" -X POST -d '{"type":102}' http://192.168.1.102:5000/set

// TYPE 103 - ZOOMOUT
curl -H "Content-Type: application/json" -X POST -d '{"type":103}' http://192.168.1.102:5000/set


## ADB COMMAND
curl -H "Content-Type: application/json" -X POST -d '{"type":300,"command":"ls"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":300,"command":"adb logcat"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":300,"command":"adb shell am start -n com.whatsapp/com.whatsapp.Main"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type": 300,"command":"am start -n com.android.chrome/com.google.android.apps.chrome.Main"}' http://192.168.1.102:5000/set


## TEXT TO SPEECH

curl -H "Content-Type: application/json" -X POST -d '{"type":1200,"text":"Hola"}' http://192.168.1.102:5000/set


Android Shell Commands:
https://github.com/jackpal/Android-Terminal-Emulator/wiki/Android-Shell-Command-Reference
----------------------
id
date
df
screenrecord /sdcard/demo.mp4



## LOAD_IMAGE
curl -H "Content-Type: application/json" -X POST -d '{"type":400,"url":"http://i.imgur.com/DvpvklR.png"}' http://192.168.1.102:5000/set

### Transformations

curl -H "Content-Type: application/json" -X POST -d '{"type":400,"url":"http://i.imgur.com/DvpvklR.png","transformation":{"name":"CropType","width":300,"height":200}}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":400,"url":"http://i.imgur.com/DvpvklR.png","transformation":{"name":"Pixel","pixel":80}}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":400,"url":"http://i.imgur.com/DvpvklR.png","transformation":{"name":"Sepia"}}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":400,"url":"http://i.imgur.com/DvpvklR.png","transformation":{"name":"CropCircle"}}' http://192.168.1.102:5000/set



curl -H "Content-Type: application/json" -X POST -d '{"type":400,"url":"http://upload.wikimedia.org/wikipedia/commons/f/f3/Arrecife_de_las_Sirenas_2_-_Almer%C3%ADa_%282569433323%29.jpg"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":400,"url":"http://upload.wikimedia.org/wikipedia/commons/f/f3/Arrecife_de_las_Sirenas_2_-_Almer%C3%ADa_%282569433323%29.jpg","x":0,"y":0,"width":20,"height":200}' http://192.168.1.102:5000/set


## TAKE PICTURE

curl -H "Content-Type: application/json" -X POST -d '{"type":500}' http://192.168.1.102:5000/set

## CHART

curl -H "Content-Type: application/json" -X POST -d '{"type":600}' http://192.168.1.102:5000/set

## SURFACEVIEW

curl -H "Content-Type: application/json" -X POST -d '{"type":700}' http://192.168.1.102:5000/set

## WEBVIEW MONITOR

curl -H "Content-Type: application/json" -X POST -d '{"type":900, "label":"Temperatura", "value": "44.31", "timestamp":"Viernes, 26 Junio, 19:45:00"}' http://192.168.1.102:5000/set

curl -H "Content-Type: application/json" -X POST -d '{"type":900, "label":"Temperatura", "value": "24.67", "timestamp":"Viernes, 26 Junio, 19:45:00"}' http://192.168.1.102:5000/set

## VIBRATE

curl -H "Content-Type: application/json" -X POST -d '{"type":1000,"milliseconds":500}' http://192.168.1.102:5000/set

## UI
### BUTTON
curl -H "Content-Type: application/json" -X POST -d '{"type":2000,"text":"Prueba","x":10,"y":500}' http://192.168.1.102:5000/set

### SEEKBAR
curl -H "Content-Type: application/json" -X POST -d '{"type":2001,"total":3}' http://192.168.1.102:5000/set