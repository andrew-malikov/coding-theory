#!/bin/bash

java -jar "../cipher-xor/cli/build/libs/cli-1.0.0.jar" \
    -p "./src/small.txt" \
    -m 42 \
    --encrypting \
    > ./out/xor-encrypted.txt
