import socket

UDP_IP = ""
UDP_PORT = 6000

print "Creating socket..."
sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
sock.bind((UDP_IP, UDP_PORT))

print "Listening..."
while True:
  # buffer size is 1024 bytes
  data, addr = sock.recvfrom(1024)
  print "Received message: ", data