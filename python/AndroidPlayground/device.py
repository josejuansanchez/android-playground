import subprocess
import time
import sys

class Device:

    def __init__(self, ip, port):
        self.ip = ip
        self.port = port

    def displayIPandPort(self):
        print("{0}:{1}".format(self.ip, self.port))

    def vibrate(self, milliseconds):
        command = ("curl http://%s:%d/set "
           "-H \"Content-Type: application/json; charset=utf-8\" "
           "-X POST "
           "-d '{\"type\":1000,"
           "\"milliseconds\":%d}' " % (self.ip, self.port, milliseconds)
          )
        print(command)
        subprocess.call(command, shell=True)

    def setBackgroundColor(self, r, g, b):
        command = ("curl http://%s:%d/set "
                   "-H \"Content-Type: application/json\" "
                   "-X POST "
                   "-d '{\"type\":701,"
                   "\"r\":%d,"
                   "\"g\":%d,"
                   "\"b\":%d}' " % (self.ip, self.port, r, g, b)
                )

        subprocess.call(command, shell=True)

    '''
    def setBackgroundColor(self, rgb):
        command = ("curl http://%s:%d/set "
                   "-H \"Content-Type: application/json\" "
                   "-X POST "
                   "-d '{\"type\":701,"
                   "\"r\":%d,"
                   "\"g\":%d,"
                   "\"b\":%d}' " % (self.ip, self.port, rgb[0], rgb[1], rgb[2])
                )

        subprocess.call(command, shell=True)
    '''