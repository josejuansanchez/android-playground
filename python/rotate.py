import subprocess

IP = "192.168.1.11"
HTTP_PORT = 5000

for i in range(0,361):
	#print i
	command = ("curl -H \"Content-Type: application/json\" -X POST -d "
			   "'{\"type\":100,"
			   "\"rotation\":%d}' "
			   "http://%s:%d/set" % (i, IP, HTTP_PORT)
			  )
	#print command
	subprocess.call(command, shell=True)