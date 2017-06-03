# TDD Fibonacci using jUnit


## Overview

### Objectives

- understand the [test-driven development](https://en.wikipedia.org/wiki/Test-driven_development) (TDD) approach to software development
- write an implementation of a [Fibonacci](https://en.wikipedia.org/wiki/Fibonacci_number) class using TDD with jUnit

### Prerequisites

- completion of [Introducing jUnit](../step-1-junit/introducing-junit.md)


## Background

### What is TDD?

The acronym TDD stands for Test-Driven Development.

This is a process where the tests are written before any development is completed &ndash; so that instead of developing the code and then writing tests, the tests drive the development of the code.

Sounds back-to-front, right?

### Why TDD?

When writing a piece of software, we start with a set of _requirements_.

The result we want is an implementation that satisfies all these requirements.

The _Test-driven development_ approach says that we can translate the _requirements_ into _tests_ – **before** even writing any code.

Which means that we will have _automated_ – and _repeatable_ – tests that prove whether the software successfully implements the requirements.

And if a bug is found, we can write one or more tests to cover the scenario that led to the bug before implementing the bug fix.

Additionally, writing tests before implementation forces us to more carefully consider how we structure our code.

And all this further increases our confidence in the code we write!


## The exercise

### Fibonacci sequence

The Fibonacci sequence is a list of numbers whereby each number is the sum of the previous two numbers.

So to demonstrate how TDD works, we will be building a Java class that calculates the _nth_ element in the Fibonacci sequence.

### Assumptions

For the purposes of this exercise, we will assume that:

- the Fibonacci sequence starts with **1**
- indexes for the series will be **zero-based**
- negative indexes are invalid

So combining the Fibonacci numbers and their indexes would look like this:

|   |   |   |   |   |   |   |   |   |
|---|---|---|---|---|---|---|---|---|
| **Index**  | `0`  | `1`  | `2`  | `3`  | `4`  |  `5` | `6`  | `7` |
| **Fibonacci number** | `1` | `1` | `2` | `3` | `5` | `8` | `13` | `21` |

Which means, for example, that passing in a parameter of `6` would return `13`.


## The first test

### Write the test

Open `FibonacciTest.java` in your editor or IDE. We will write tests in the same way that we wrote tests in the previous lesson:

```java
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {
    private Fibonacci fibonacci;

    @Before
    public void setUp() {
        fibonacci = new Fibonacci();
    }

    @Test
    public void calculate_0() {
        int testIndex = 0;
        int expectedResult = 0;

        fibonacci.setIndex(testIndex);
        assertEquals(expectedResult, fibonacci.calculate());
    }
}
```

### Run the test

Use the `run-tests.bash` script provided:

```bash
./run-tests.bash
```

Expected output:

```
+ export CLASSPATH=.:junit-4.12.jar:hamcrest-core-1.3.jar
+ CLASSPATH=.:junit-4.12.jar:hamcrest-core-1.3.jar
+ javac Fibonacci.java FibonacciTest.java
FibonacciTest.java:17: error: cannot find symbol
        assertEquals(expectedResult, fibonacci.calculate());
                                              ^
  symbol:   method calculate()
  location: variable fibonacci of type Fibonacci
1 error
```

This is exactly what we would expect when taking a TDD approach: we have written a test for code that has not yet been implemented, so the test will fail.

### Write code for the test

In its most basic form, TDD requires that you only write enough code &ndash; and nothing more &ndash; to make the failing test pass.

So let's add some code to `FibonacciTest.java` to make the failing test pass:

```java
class Fibonacci {
    private int index = 0;

    public void setIndex(int index) {
        this.index = index;
    }

    public int calculate() {
        return this.index;
    }
}
```

### Run the test again

And you should see output like this:

```
+ export CLASSPATH=.:junit-4.12.jar:hamcrest-core-1.3.jar
+ CLASSPATH=.:junit-4.12.jar:hamcrest-core-1.3.jar
+ javac Fibonacci.java FibonacciTest.java
+ java org.junit.runner.JUnitCore FibonacciTest
JUnit version 4.12
.
Time: 0.013

OK (1 test)
```

We have completed writing the first test, so it's now time to repeat the process until we believe we have written sufficient tests.

> **TODO:** complete lesson


## Conclusion

### What we've covered

- 

### Further reading

- 

### Final code and output

