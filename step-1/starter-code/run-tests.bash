#!/bin/bash -ex

JUNIT_JAR=junit-4.12.jar
HAMCREST_CORE_JAR=hamcrest-core-1.3.jar
export CLASSPATH=.:${JUNIT_JAR}:${HAMCREST_CORE_JAR}

javac Factorial.java FactorialTest.java
java org.junit.runner.JUnitCore FactorialTest
