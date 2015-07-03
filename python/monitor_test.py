import subprocess
import random
import time
import datetime

IP = "192.168.1.102"
HTTP_PORT = 5000

for i in range(0,60):
	# generate a random value between [10, 30)
	value = random.uniform(10, 30)

	# get the current timestamp
	ts = time.time()
	timestamp = datetime.datetime.fromtimestamp(ts).strftime('%Y-%m-%d %H:%M:%S')

	command = ("curl -H \"Content-Type: application/json\" -X POST -d "
			   "'{\"type\":900, "
			   "\"label\":\"Temperatura\", "
			   "\"value\": \"%.2f\", \"timestamp\":\"%s\"}' "
			   "http://%s:%d/set"  % (value, timestamp, IP, HTTP_PORT)
			   )

	#print command
	subprocess.call(command, shell=True)

	# suspend execution for 1 second
	time.sleep(1)