#!/bin/bash

while [  0 -lt 1 ]; do

# Samsung
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"http://192.168.1.10:8000/hello.png","x":0,"y":0,"width":800,"height":1168}' http://192.168.1.19:5000/set

# Nexus 7
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"http://192.168.1.10:8000/hello.png","x":-800,"y":0,"width":600,"height":823}' http://192.168.1.12:5000/set

# Nexus 6
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"http://192.168.1.10:8000/hello.png","x":-1400,"y":0,"width":412,"height":603}' http://192.168.1.108:5000/set


sleep 2s


# Samsung
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"http://192.168.1.10:8000/world.png","x":0,"y":0,"width":800,"height":1168}' http://192.168.1.19:5000/set

# Nexus 7
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"http://192.168.1.10:8000/world.png","x":-800,"y":0,"width":600,"height":823}' http://192.168.1.12:5000/set

# Nexus 6
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"http://192.168.1.10:8000/world.png","x":-1400,"y":0,"width":412,"height":603}' http://192.168.1.108:5000/set


sleep 2s


# Samsung
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"http://192.168.1.10:8000/thisis.png","x":0,"y":0,"width":800,"height":1168}' http://192.168.1.19:5000/set

# Nexus 7
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"http://192.168.1.10:8000/thisis.png","x":-800,"y":0,"width":600,"height":823}' http://192.168.1.12:5000/set

# Nexus 6
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"http://192.168.1.10:8000/thisis.png","x":-1400,"y":0,"width":412,"height":603}' http://192.168.1.108:5000/set


sleep 2s


# Samsung
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"http://192.168.1.10:8000/my.png","x":0,"y":0,"width":800,"height":1168}' http://192.168.1.19:5000/set

# Nexus 7
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"http://192.168.1.10:8000/my.png","x":-800,"y":0,"width":600,"height":823}' http://192.168.1.12:5000/set

# Nexus 6
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"http://192.168.1.10:8000/my.png","x":-1400,"y":0,"width":412,"height":603}' http://192.168.1.108:5000/set


sleep 2s


# Samsung
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"http://192.168.1.10:8000/first.png","x":0,"y":0,"width":800,"height":1168}' http://192.168.1.19:5000/set

# Nexus 7
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"http://192.168.1.10:8000/first.png","x":-800,"y":0,"width":600,"height":823}' http://192.168.1.12:5000/set

# Nexus 6
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"http://192.168.1.10:8000/first.png","x":-1400,"y":0,"width":412,"height":603}' http://192.168.1.108:5000/set


sleep 2s


# Samsung
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"http://192.168.1.10:8000/experiment.png","x":0,"y":0,"width":800,"height":1168}' http://192.168.1.19:5000/set

# Nexus 7
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"http://192.168.1.10:8000/experiment.png","x":-800,"y":0,"width":600,"height":823}' http://192.168.1.12:5000/set

# Nexus 6
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"http://192.168.1.10:8000/experiment.png","x":-1400,"y":0,"width":412,"height":603}' http://192.168.1.108:5000/set


sleep 2s


# Samsung
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"bla","x":0,"y":0,"width":800,"height":1168}' http://192.168.1.19:5000/set

# Nexus 7
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"bla","x":-800,"y":0,"width":600,"height":823}' http://192.168.1.12:5000/set

# Nexus 6
curl -H "Content-Type: application/json" -X POST -d '{"type":0,"url":"bla","x":-1400,"y":0,"width":412,"height":603}' http://192.168.1.108:5000/set

done