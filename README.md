# Parallel Prefix Sum Project

This project demonstrates the computation of prefix sums using both sequential and parallel approaches in Java. The project includes two main files:

- `ParallelPrefixSum.java` - Implements the parallel prefix sum using the ForkJoin framework.
- `PrefixSum.java` - Implements the sequential prefix sum calculation.

## Table of Contents

- [Introduction](#introduction)
- [Requirements](#requirements)
- [Files Description](#files-description)
- [How to Run](#how-to-run)
- [Performance](#performance)
- [References](#references)

## Introduction

Prefix sum (also known as a cumulative sum) is an operation on an array where each element at index `i` is replaced by the sum of elements from index `0` to `i`. This project explores both sequential and parallel implementations of the prefix sum to showcase the performance benefits of parallel computation.

## Requirements

- Java Development Kit (JDK) 8 or higher

## Files Description

### ParallelPrefixSum.java

This file contains the implementation of the parallel prefix sum using Java's ForkJoin framework. It includes the following components:

- `PrefixSumTask`: A `RecursiveAction` task that divides the array into smaller sub-tasks until a threshold is reached, at which point it computes the prefix sum sequentially.
- `ParallelPrefixSum`: The main class that initializes a random array and executes the prefix sum computation using a `ForkJoinPool`.

### PrefixSum.java

This file contains the sequential implementation of the prefix sum calculation. It includes the following components:

- `generateRandomArray`: Generates an array of random integers.
- `calculatePrefixSum`: Computes the prefix sum of the given array sequentially.
- `PrefixSum`: The main class that initializes a random array and measures the time taken to compute the prefix sum.

## How to Run

Compile the files:

```bash
javac ParallelPrefixSum.java
javac PrefixSum.java
```

Run the sequential version:

```bash
java PrefixSum
```

Run the parallel version:

```bash
java ParallelPrefixSum
```

## Performance

The performance of the prefix sum calculation can be compared by measuring the time taken by both sequential and parallel implementations for a large array. The elapsed time for each execution is printed in milliseconds. Generally, the parallel implementation should demonstrate better performance on multi-core processors, especially for large arrays.

## References

[Java ForkJoin Framework: Java Documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ForkJoinPool.html)

[RecursiveAction: Java Documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/RecursiveAction.html)
