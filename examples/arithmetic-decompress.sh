#!/bin/bash

cat "./out/arithmetic-compressed.txt" | java -jar \
    "../arithmetic-coding/decompressing-cli/build/libs/decompressing-cli-1.0.0.jar"
