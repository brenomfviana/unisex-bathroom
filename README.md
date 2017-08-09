# Unisex Bathroom Problem

## Description

This is a work from the Concurrent Programming course in which two solutions were implemented using different methods of synchronization. The methods used to solve the problem were explicit locks and semaphores.

## Problem

#### Unisex Bathroom

An office has a bathroom that can be used by both men and women, but not both at the same time. If a man is in the bathroom, other men may enter, but any women wishing to use the bathroom should wait for it to be empty. If a woman is in the bathroom, other women may enter, but any men wishing to use the bathroom should wait it to be empty. Each person (man or woman) will spend some time using the bathroom.

Design and implement a concurrent solution to the problem. The program should show when a person (man or woman) enters or exits the bathroom; as well as how many people (men or women) are in the bathroom at the moment. Because it is a space of relatively small size, the bathroom has a limiting capacity of persons *C* (provided as input via the command line or prefixed as a constant value) that can use it at the same time and the time that each person passes in the bathroom is random and different to each program execution.

## Compiling and Running

We usually use an IDE (like NetBeans or Eclipse) to compile and build the program, but if you want to compile via terminal use the following commands.

### Dependencies

- Java 8.0 or greater

### Unisex Bathroom Lock

Open the project folder:

```bash
cd UnisexBathroomLock
```

#### How to compile

Run the following commands:

```bash
./make.sh
```

##### ```make.sh``` content

```sh
#!/bin/bash
cd src
# Compile
javac unissexbathroomlock/control/*.java unissexbathroomlock/bathroom/*.java unissexbathroomlock/person/*.java
# Generate jar
jar cfm ../UnisexBathroomLock.jar ../manifest.mf unissexbathroomlock/control/*.class unissexbathroomlock/bathroom/*.class unissexbathroomlock/person/*.class
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

Run the following commands:

```bash
./make.sh
```

##### ```make.sh``` content

```sh
#!/bin/bash
cd src
# Compile
javac unisexbathroomsemaphore/control/*.java unisexbathroomsemaphore/bathroom/*.java unisexbathroomsemaphore/person/*.java
# Generate jar
jar cfm ../UnisexBathroomSemaphore.jar ../manifest.mf unisexbathroomsemaphore/control/*.class unisexbathroomsemaphore/bathroom/*.class unisexbathroomsemaphore/person/*.class
```

#### How to run

```bash
java -jar UnisexBathroomSemaphore.jar
```

## Team

[<img src="https://avatars2.githubusercontent.com/u/17532418?v=3&s=400" width="100"/>](https://github.com/brenov) | [<img src="https://avatars2.githubusercontent.com/u/17392686?v=3&s=400" width="100"/>](https://github.com/Pekorishia)
---|---
[Breno Viana](https://github.com/brenov) | [Patrícia Cruz](https://github.com/Pekorishia)
