#!/bin/bash

message=`cat ./out/lzw-encoded.txt`

java -jar "../lzw-cli/build/libs/lzw-cli-1.0.0.jar" \
    -m "$message" \
    -s 256 --decoding
