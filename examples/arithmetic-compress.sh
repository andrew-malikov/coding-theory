#!/bin/bash

message=`cat ./src/small.txt`

java -jar "../arithmetic-coding/compressing-cli/build/libs/cli-1.0.0.jar" -l 2 <<< "$message"
