#!/bin/bash

transpositions="[{\"from\":15,\"to\":14},{\"from\":13,\"to\":12}]"

java -jar "../cipher-transposition-cli/build/libs/cipher-transposition-cli-1.0.0.jar" \
    -p "./src/small.txt" \
    -t "$transpositions" \
    --encrypting \
    > ./out/transposition-encrypted.txt
