JAVA 8
======

Example Java code using lambdas and Streams.

## Compile with Maven
You can compile all the Java classes using Maven

```
$ mvn compile
```
Maven will create a folder target/classes containing all the complied Java classes.

## Execute the Java classes
Add the target/classes folder in the classpath to execute a Java class as in the example

```
$ java -cp "target/classes" chapter5.FileSource
``` 
## HackerRank Challenges
The package hr.* contains tests from [HackerRank](https://www.hackerrank.com/). A description of each test
is available under the folder hr in src/main/resources with some input data. The solutions may not be fully
tested so they are just a first attempt to solve a problem. There is an execution time limit of 4 seconds for
the Java8 code submitted to HackerRank and a memory limit of 512 MB. 
