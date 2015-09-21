# -*- coding: utf-8 -*-

import subprocess
import time
import random
import sys

IP = "192.168.1.11"
HTTP_PORT = 5000

if len(sys.argv) < 2:
    print("Usage: sys.argv[0] <text_to_say>")
    sys.exit(1)

text = str(sys.argv[1])

command = ("curl http://%s:%d/set "
           "-H \"Content-Type: application/json; charset=utf-8\" "
           "-X POST "
           "-d '{\"type\":1200,"
           "\"text\":\"%s\"}' " % (IP, HTTP_PORT, text)
          )

print command
subprocess.call(command, shell=True)