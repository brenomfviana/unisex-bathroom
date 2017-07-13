# Unisex Bathroom Problem

## Description

This is a work of the Concurrent Programming course in which two solutions were implemented using different methods of synchronization.

## Problem

#### Unisex Bathroom

An office has a bathroom that can be used by both men and women, but not both at the same time. If a man is in the bathroom, other men may enter, but any women wishing to use the bathroom should expect it to be empty. If a woman is in the bathroom, other women may enter, but any men wishing to use the bathroom should expect it to be empty. Each person (man or woman) can spend time using the bathroom.

Design and implement a concurrent solution to the problem. The program should show the entrance and exit of a person (man or woman) from the bathroom as well as how many people (men or women) are in the bathroom at the moment. Because it is a space of relatively small size, the bathroom has a limiting capacity of persons C (provided as input via the command line or prefixed as a constant value) that can use it at the same time and the time that each person passes in the bathroom Is random and different to each program execution.

## Compiling and Running

We usually use an IDE (like NetBeans or Eclipse) to compile and build the program, but if you want to compile via terminal use the following commands.

### Unisex Bathroom Lock

Open the project folder:

```bash
cd UnisexBathroomLock
```

#### How to compile

To compile enter the following command:

```bash
javac src/unissexbathroomlock/control/*.java src/unissexbathroomlock/bathroom/*.java src/unissexbathroomlock/person/*.java
```

#### How to generate executable

To generate the jar executable run the following command:

```bash
jar cfm UnisexBathroomLock.jar manifest.mf src/unissexbathroomlock/control/*.class src/unissexbathroomlock/bathroom/*.java src/unissexbathroomlock/person/*.class
```

#### How to run

```bash
java -jar UnisexBathroomLock.jar
```

### Unisex Bathroom Semaphore

Open the project folder:

```bash
cd UnisexBathroomSemaphore
```

#### How to compile

To compile enter the following command:

```bash
javac src/unissexbathroomsemaphore/control/*.java src/unissexbathroomsemaphore/bathroom/*.java src/unissexbathroomsemaphore/person/*.java
```

#### How to generate executable

To generate the jar executable run the following command:

```bash
jar cfm UnisexBathroomSemaphore.jar manifest.mf src/unissexbathroomsemaphore/control/*.class src/unissexbathroomsemaphore/bathroom/*.java src/unissexbathroomsemaphore/person/*.class
```

#### How to run

```bash
java -jar UnisexBathroomSemaphore.jar
```

## Team

[<img src="https://avatars2.githubusercontent.com/u/17532418?v=3&s=400" width="100"/>](https://github.com/brenov) | [<img src="https://avatars2.githubusercontent.com/u/17392686?v=3&s=400" width="100"/>](https://github.com/Pekorishia)
---|---
[Breno Viana](https://github.com/brenov) | [Patrícia Cruz](https://github.com/Pekorishia)
