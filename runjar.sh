#!/bin/bash


JAR_FILE=`find -t f -name *.jar`

echo "Executing jar: $JAR_FILE"

java -jar ./target/$JAR_FILE --serviceName=testservice 
