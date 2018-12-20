#!/bin/bash

java -jar "../cipher-caesar-cli/build/libs/cipher-caesar-cli-1.0.0.jar" \
    -p "./out/caesar-encrypted.txt" \
    -s 42 \
    -t 65536 \
    --decrypting
