import subprocess

IP = "192.168.1.102"
HTTP_PORT = 5000

for i in range(0,100):
	#print i
	command = ("curl -H \"Content-Type: application/json\" -X POST -d "
			   "'{\"type\":103}' http://%s:%d/set" % (IP, HTTP_PORT)
			  )
	#print command
	subprocess.call(command, shell=True)