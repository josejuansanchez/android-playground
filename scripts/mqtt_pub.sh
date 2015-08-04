#!/bin/bash
#
# Publish
set -x

TOPIC='my-topic'
MESSAGE='test message'
BROKER_HOST='test.mosquitto.org'

mqtt pub -t $TOPIC -h $BROKER_HOST -m "$MESSAGE"