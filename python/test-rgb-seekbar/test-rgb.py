import serial
import time
import random

port = '/dev/cu.usbmodem1411'
baudrate = 115200

r = 0
g = 0
b = 0

ser = serial.Serial(port, baudrate)

while True:
	message = '{"r":%d, "g":%d, "b":%d}' % (r,g,b)
	print message
	ser.write(message)
	
	time.sleep(1)
	print ser.readline()

	r = random.randint(0, 255)
	g = random.randint(0, 255)
	b = random.randint(0, 255)