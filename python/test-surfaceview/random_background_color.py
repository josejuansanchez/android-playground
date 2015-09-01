import subprocess
import time
import random

IP = "192.168.1.11"
HTTP_PORT = 5000

while True:
	r = random.randint(0, 255)
	g = random.randint(0, 255)
	b = random.randint(0, 255)

	command = ("curl http://%s:%d/set "
			   "-H \"Content-Type: application/json\" "
			   "-X POST "
			   "-d '{\"type\":701,"
			   "\"r\":%d,"
			   "\"g\":%d,"
			   "\"b\":%d}' " % (IP, HTTP_PORT, r, g, b)
				)
	#print command
	subprocess.call(command, shell=True)
	time.sleep(0.5)