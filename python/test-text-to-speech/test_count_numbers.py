import subprocess
import time
import random

IP = "192.168.1.11"
HTTP_PORT = 5000

for number in range(0,10):
command = ("curl http://%s:%d/set "
           "-H \"Content-Type: application/json\" "
           "-X POST "
           "-d '{\"type\":1200,"
           "\"text\":%d}' " % (IP, HTTP_PORT, number)
          )
    #print command
    subprocess.call(command, shell=True)
    #time.sleep(0.5)