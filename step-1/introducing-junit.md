# Introducing jUnit


## Overview

### Objectives

- understand what jUnit is and how it works
- write a simple Java class and some jUnit tests for it
- learn some simple optimisation for jUnit tests
- automate the test running with a simple shell script

### Prerequisites

- an understanding of how to use git and GitHub
- a basic understanding of the Java programming language
- a system that runs some flavour of Unix or Linux; for Windows 10 users, see the [Windows Subsystem for Linux (WSL) Installation Guide](https://msdn.microsoft.com/en-gb/commandline/wsl/install_guide)
- software installed:
  - git 2.x
  - java 8


## jUnit

### What is jUnit?

> TODO


## Writing a simple jUnit test

> Note: the code described below is an adaptation of [https://github.com/junit-team/junit4/wiki/Getting-started](https://github.com/junit-team/junit4/wiki/Getting-started).
> To keep things simple, the starter code already contains the Jar files needed to run the jUnit tests.

### Getting started

- you may want to fork this repo
- clone the repo to your local machine
- open the project in your editor or IDE
- open a terminal application, and make sure you are in the `starter-code` directory


### Create a simple Java class

We'll take a simple requirement: write a Java class to implement [factorial](https://en.wikipedia.org/wiki/Factorial) functionality:

```java
public class Factorial {
    private int start = 0;

    private int factorial(int n) {
        int result = n;

        if (result > 1) {
            result = n * factorial(n - 1);
        }

        return result;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int calculate() {
        return factorial(start);
    }
}
```

> NOTE: this is a slightly contrived example – the main purpose is to enable us to see how a set of jUnit tests can be developed, including the ability to use `@Before` to define steps that are common to all tests.

### Write a test class

Let's now write a class that jUnit can use to test the `Factorial` class:

```java
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FactorialTest {
    @Test
    public void calculate_default() {
        Factorial factorial = new Factorial();
        int expectedResult = 0;
        int actualResult = factorial.calculate();

        assertEquals(expectedResult, actualResult);
    }
}
```

Note each part of that test class:

- imports 
- the name of the test class is the class we are going to test, plus `Test`
- the `@Test` annotation indicates the start of a test
- the name of the method gives an indicator of what we are testing
- within the test:
  - get a new instance of the class we want to test
  - and a variable to contain the expected result
  - and a variable that contains the actual result
  - the naming of these variables describes (documents) their function

### Run the test

In order to be able to run the test, we need to first compile the two Java classes:

```bash
javac -classpath .:junit-4.12.jar:hamcrest-core-1.3.jar Factorial.java FactorialTest.java
```

Then we can run the test:

```bash
java -classpath .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore FactorialTest
```

### Automate running the test

Having to specify the class path before every command is tiresome. We can automate the whole process by writing a simple shell script:
 
```bash
#!/bin/bash -ex

JUNIT_JAR=junit-4.12.jar
HAMCREST_CORE_JAR=hamcrest-core-1.3.jar
export CLASSPATH=.:${JUNIT_JAR}:${HAMCREST_CORE_JAR}

javac Factorial.java FactorialTest.java
java org.junit.runner.JUnitCore FactorialTest
```

Now run that script:

```bash
./run-tests.bash
```

Sample output:

```
+ JUNIT_JAR=junit-4.12.jar
+ HAMCREST_CORE_JAR=hamcrest-core-1.3.jar
+ export CLASSPATH=.:junit-4.12.jar:hamcrest-core-1.3.jar
+ CLASSPATH=.:junit-4.12.jar:hamcrest-core-1.3.jar
+ javac Factorial.java FactorialTest.java
+ java org.junit.runner.JUnitCore FactorialTest
JUnit version 4.12
.
Time: 0.015

OK (1 test)
```

## Taking it further

We'll now add a couple more tests, and look at a simple way of optimising the tests.

### Test setting the start value

The `Factorial` class exposes a `setStart()` method; let's write a test to check this works correctly:

```java
    @Test
    public void calculate_setStart_1() {
        Factorial factorial = new Factorial();
        int testStartValue = 1;
        int expectedResult = 1;

        factorial.setStart(testStartValue);
        assertEquals(expectedResult, factorial.calculate());
    }
```

Note the simple convention we are using when naming each test – each method is made up of three parts, separated by the `_` character:

- the name of the method we are testing (in this case, we are only testing the `calculate()` method)
- a method that we are calling (`setStart()`) on the instance of the `Factorial` class
- the value passed to that second method

This is a useful way, but not the only way, to name test methods; you may find other ways – the main thing is for the naming convention to be readable and consistent.

Run the tests again:

```bash
./run-tests.bash
```

Sample output:

```
+ JUNIT_JAR=junit-4.12.jar
+ HAMCREST_CORE_JAR=hamcrest-core-1.3.jar
+ export CLASSPATH=.:junit-4.12.jar:hamcrest-core-1.3.jar
+ CLASSPATH=.:junit-4.12.jar:hamcrest-core-1.3.jar
+ javac Factorial.java FactorialTest.java
+ java org.junit.runner.JUnitCore FactorialTest
JUnit version 4.12
..
Time: 0.012

OK (2 tests)
```

## Some optimisation

### DRY: Don't Repeat Yourself

If you inspect the test class, you will notice that a new instance of the `Factorial` class is instantiated in each test.

A common pattern you will find in testing frameworks for most programming languages is to be able to specify a block of code that is automatically run before each test.

With jUnit, we use the `@Before` annotation.

Here's what we will do:

- import the `Before` annotation
- declare a private `factorial` variable to hold the `Factorial` instance on the test class – this will be accessible by all tests in the class
- add a `@Before` code block in the test class – this will instantiate the `Factorial` class
- remove the code that instantiates the `Factorial` class within each test, and refactor it to use the private `factorial` class variable

> Implement each of those changes in `FactorialTest.java`

Once you have finished making those changes, the test class will look like this:

```java
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class FactorialTest {
    private Factorial factorial;

    @Before
    public void setUp() {
        factorial = new Factorial();
    }

    @Test
    public void calculate_default() {
        int expectedResult = 0;
        int actualResult = factorial.calculate();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculate_setStart_1() {
        int testStartValue = 1;
        int expectedResult = 1;

        factorial.setStart(testStartValue);
        assertEquals(expectedResult, factorial.calculate());
    }
}
```

### Add another test

> TODO


## Conclusion

### What we've covered

- what jUnit is
- how to write jUnit tests
- and automate the testing process with a simple shell script
- and optimise tests using `@Before`

### Further reading

- http://junit.org/junit4/
- https://github.com/junit-team/junit4
- https://en.wikipedia.org/wiki/Hamcrest
