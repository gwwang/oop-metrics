# OOP Project - Collecting Metrics

## Description
This project focuses on Object Oriented Programming (OOP) with a little bit of patterns and some OOP principles.

You are going to implement classes that fulfill their interface contracts.  The end result is a program that simulates a client and server interaction while collecting metrics about each call. Once the simulation is complete, the output will be printed on the console 

## How to use this repo

This repository (repo for short) provides the basic skeleton for executing your changes.  The main class
is the ```Simulator```.  As you will be working with an IDE (intellij or eclipse), 
you can easily run the ```main``` method in the ```Simulator``` class.

Each task will have its own branch in this repo. For example, Task 1 is in branch ```task1```.
The ```master``` branch contains a working example with an ```ExampleMetricsReporter```
and ```ExampleMetricsReporterFactory```.  How they are passed to the ```Simulator``` is 
found in the ```Configuration``` class.

For each task, you should also ensure that the tests will still work, as they are
the first indicators that something is wrong.  

```
# to clean up 
> mvn clean
```
```
# to compile
> mvn compile
```
```
# to run the tests
> mvn test
```
```
# you can combine tasks
> mvn clean compile test
```
```
# some tasks can be omitted as they are inferred
> mvn clean test
```

