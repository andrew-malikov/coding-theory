#!/bin/bash

app="../arithmetic-coding/decompressing-cli/build/libs/decompressing-cli-1.0.0.jar"

cat ./out/arithmetic-compression.txt | java -jar $app
