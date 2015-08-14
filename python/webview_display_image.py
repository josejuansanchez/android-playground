import subprocess

IP = "localhost"
HTTP_PORT = 5000

for i in range(0,1000):
	#print i
	command = ("curl -H \"Content-Type: application/json\" -X POST -d "
			   "'{\"type\":0,"
			   "\"url\":\"http://192.168.43.175:8000/hello.png\","
			   "\"x\":-%d,"
			   "\"y\":0,"
			   "\"width\":412,"
			   "\"height\":603}' "
			   "http://%s:%d/set" % (i, IP, HTTP_PORT)
			  )
	#print command
	subprocess.call(command, shell=True)