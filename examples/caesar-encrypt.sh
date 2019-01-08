#!/bin/bash

java -jar "../cipher-caesar/cli/build/libs/cli-1.0.0.jar" \
    -p "./src/small.txt" \
    -s 42 \
    -t 65536 \
    --encrypting \
    > ./out/caesar-encrypted.txt
