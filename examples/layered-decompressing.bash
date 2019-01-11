#!/bin/bash

app="../layered-compression/decompressing-cli/build/libs/decompressing-cli-1.0.0.jar"
args="-r 256"

cat ./out/layered-compression.txt | java -jar $app $args
