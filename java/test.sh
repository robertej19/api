#!/usr/bin/bash

JARS=`find lib -name '*.jar' -print0 | tr '\0' ':' | head -c -1`
SOURCE_FILES=`find src -name '*.java'`
TEST_FILES=`find test -name '*.java'`

RT17JAR=`locate java | grep '1\.7' | grep 'lib/rt\.jar' | tail -1`
OPTS="-source 1.7 -target 1.7 -bootclasspath $RT17JAR"

echo "jars: $JARS"

echo "creating gemc.jar..."
javac $OPTS -classpath src:$JARS $SOURCE_FILES || exit -1
jar cf gemc.jar -C src . || exit -2

echo "compiling tests..."
JARS=$JARS:gemc.jar
javac $OPTS -classpath test:$JARS $TEST_FILES || exit -3

java -cp test:$JARS gemc.TestRunner || exit -3
