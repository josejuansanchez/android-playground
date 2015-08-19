import subprocess
import random
import time
import datetime

IP = "192.168.1.11"
HTTP_PORT = 5000
MESSAGE_TYPE = 1101

samples = ["http://html5demos.com/assets/dizzy.mp4",
           "https://devimages.apple.com.edgekey.net/"
           + "streaming/examples/bipbop_4x3/gear0/fileSequence0.aac",
           "https://devimages.apple.com.edgekey.net/streaming/examples/"
           + "bipbop_4x3/gear1/fileSequence0.ts",
           "http://redirector.c.youtube.com/videoplayback?id=604ed5ce52eda7ee&itag=22&source=youtube&"
           + "sparams=ip,ipbits,expire,source,id&ip=0.0.0.0&ipbits=0&expire=19000000000&signature="
           + "513F28C7FDCBEC60A66C86C9A393556C99DC47FB.04C88036EEE12565A1ED864A875A58F15D8B5300"
           + "&key=ik0",
           "http://demos.webmproject.org/exoplayer/glass_vp9_vorbis.webm"
          ]

for i in range(0,60):
	# generate a random value between [0, len(samples)-1)
	value = random.randint(0, len(samples)-1)

	# get the current timestamp
	ts = time.time()
	timestamp = datetime.datetime.fromtimestamp(ts).strftime('%Y-%m-%d %H:%M:%S')

	command = ("curl -H \"Content-Type: application/json\" -X POST -d "
			   "'{\"type\":%d, "
			   "\"url\":\"%s\" }' "
			   "http://%s:%d/set"  % (MESSAGE_TYPE, samples[value], IP, HTTP_PORT)
			   )

	#print command
	subprocess.call(command, shell=True)

	# suspend execution for 5 second
	time.sleep(5)
