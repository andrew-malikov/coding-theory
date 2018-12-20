#!/bin/bash

java -jar "../cipher-xor-cli/build/libs/cipher-xor-cli-1.0.0.jar" \
    -p "./out/xor-encrypted.txt" \
    -m 42 \
    --decrypting
