#!/bin/bash

message=`cat ./src/small.txt`

java -jar "../lzw-cli/build/libs/lzw-cli-1.0.0.jar" \
    -m "$message" \
    -s 256 --encoding \
    > ./out/lzw-encoded.txt
