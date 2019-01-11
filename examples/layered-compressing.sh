#!/bin/bash

app="../layered-compression/compressing-cli/build/libs/compressing-cli-1.0.0.jar"
args="-l 6 -r 256"

data=`cat ./src/basic.txt`

java -jar $app $args <<< "$data" > ./out/layered-compression.txt
