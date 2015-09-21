# -*- coding: utf-8 -*-

import subprocess
import time
import random

IP = "192.168.1.104"
HTTP_PORT = 5000

quotes = ["Una vez al año no hace daño.",
          "A palabras necias, oídos sordos.",
          "Cuando las barbas de tu vecino veas cortar, pon las tuyas a remojar.",
          "No sólo de pan vive el hombre."
         ]

for index in range(0,4):
    command = ("curl http://%s:%d/set "
               "-H \"Content-Type: application/json; charset=UTF-8\" "
               "-X POST "
               "-d '{\"type\":1200,"
               "\"text\":\"%s\"}' " % (IP, HTTP_PORT, quotes[index])
              )
    #print command
    subprocess.call(command, shell=True)
    time.sleep(0.2)