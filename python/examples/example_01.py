import sys
import os.path
import time

sys.path.append(os.path.join(os.path.dirname(__file__), '..'))
from AndroidPlayground.device import Device

device = Device("192.168.1.11", 5000)
device.displayIPandPort()

device.vibrate(15)

device.setBackgroundColor(0, 0, 255)
time.sleep(0.5)
device.setBackgroundColor(0, 255, 255)
time.sleep(0.5)
device.setBackgroundColor(255, 255, 255)
time.sleep(0.5)
device.setBackgroundColor(255, 255, 0)