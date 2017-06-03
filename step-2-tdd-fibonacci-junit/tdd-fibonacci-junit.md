# TDD Fibonacci using jUnit


## Overview

### Objectives

- understand the [test-driven development](https://en.wikipedia.org/wiki/Test-driven_development) (TDD) approach to software development
- write an implementation of a [Fibonacci](https://en.wikipedia.org/wiki/Fibonacci_number) class using TDD with jUnit

### Prerequisites

- completion of [Introducing jUnit](../step-1-junit/introducing-junit.md)


## Building the code

### Why TDD?

When writing a piece of software, we start with a set of _requirements_.

The result we want is an implementation that satisfies all these requirements.

The _Test-driven development_ approach says that we can translate the _requirements_ into _tests_ – **before** even writing any code.

Which means that we will have _automated_ – and _repeatable_ – tests that prove whether the software successfully implements the requirements.

And if a bug is found, we can write one or more tests to cover the scenario that led to the bug before implementing the bug fix.

Additionally, writing tests before implementation forces us to more carefully consider how we structure our code.

And all this further increases our confidence in the code we write!


### Assumptions

For the purposes of this exercise, we will assume that the Fibonacci sequence starts with **1**, and that indexes for the series will be **zero-based**.

So the sequence will look like this:

```
1, 1, 2, 3, 5, 8, 13, 21, ...
```

And the indexes of the above elements will be:

```
0, 1, 2, 3, 4, 5, 6, 7, ...
```

Which means, for example, that calling `fibonacci(5)` would return `8`.


> **TODO:** the rest of the lesson


## Conclusion

### What we've covered

- 

### Further reading

- 

### Final code and output

