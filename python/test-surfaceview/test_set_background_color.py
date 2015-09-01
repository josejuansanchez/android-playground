import subprocess
import time
import random

IP = "192.168.1.11"
HTTP_PORT = 5000

for r in range(0,255):
  for g in range(0,255):
    for b in range(0,255):
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