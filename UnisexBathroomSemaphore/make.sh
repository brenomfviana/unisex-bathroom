#!/bin/bash
cd src
# Compile
javac unisexbathroomsemaphore/control/*.java unisexbathroomsemaphore/bathroom/*.java unisexbathroomsemaphore/person/*.java
# Generate jar
jar cfm ../UnisexBathroomSemaphore.jar ../manifest.mf unisexbathroomsemaphore/control/*.class unisexbathroomsemaphore/bathroom/*.class unisexbathroomsemaphore/person/*.class
