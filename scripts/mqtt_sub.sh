#!/bin/bash
#
# Subscribe
set -x

TOPIC='my-topic'
BROKER_HOST='test.mosquitto.org'

mqtt sub -t $TOPIC -h $BROKER_HOST -v