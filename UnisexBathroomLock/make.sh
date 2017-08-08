#!/bin/bash
cd src
# Compile
javac unissexbathroomlock/control/*.java unissexbathroomlock/bathroom/*.java unissexbathroomlock/person/*.java
# Generate jar
jar cfm ../UnisexBathroomLock.jar ../manifest.mf unissexbathroomlock/control/*.class unissexbathroomlock/bathroom/*.class unissexbathroomlock/person/*.class
