#!/bin/bash -x

JUNIT_JAR=junit-4.12.jar
HAMCREST_CORE_JAR=hamcrest-core-1.3.jar

javac Calculator.java
javac -cp .:${JUNIT_JAR} CalculatorTest.java
java -cp .:${JUNIT_JAR}:${HAMCREST_CORE_JAR} org.junit.runner.JUnitCore CalculatorTest
