import subprocess

IP = "192.168.1.11"
HTTP_PORT = 5000

for i in range(0, 1000, 10):
	#print i
	command = ("curl -H \"Content-Type: application/json\" -X POST -d "
			   "'{\"type\":0,"
			   "\"url\":\"http://192.168.1.14:8000/hello.png\","
			   "\"x\":-%d,"
			   "\"y\":0,"
			   "\"width\":412,"
			   "\"height\":603}' "
			   "http://%s:%d/set" % (i, IP, HTTP_PORT)
			  )
	#print command
	subprocess.call(command, shell=True)