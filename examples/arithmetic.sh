#!/bin/bash

message=`cat ./src/small.txt`

java -jar "../arithmetic-coding-cli/build/libs/arithmetic-coding-cli-1.0.0.jar" \
    -m "$message"
