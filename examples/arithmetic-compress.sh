#!/bin/bash

app="../arithmetic-coding/compressing-cli/build/libs/compressing-cli-1.0.0.jar"
args="-l 12"

data=`cat ./src/large.txt`

java -jar $app $args <<< "$data" > ./out/arithmetic-compression.txt
