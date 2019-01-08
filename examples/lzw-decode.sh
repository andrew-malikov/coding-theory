#!/bin/bash

message=`cat ./out/lzw-encoded.txt`

java -jar "../lzw/cli/build/libs/cli-1.0.0.jar" \
    -m "$message" \
    -s 256 --decoding
