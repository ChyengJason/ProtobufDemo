#!/usr/bin/env bash
// brew install protoc
// --java_out 输出文件目录 需要转换的proto文件路径
protoc --java_out=./app/src/main/java ./app/src/proto/Person.proto


