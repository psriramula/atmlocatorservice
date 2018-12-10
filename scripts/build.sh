#!/bin/sh

APP="atm-locator-service"
VERSION=1.0
echo "Building $APP"
cd ..

echo "Compiling and testing the application "
sbt clean compile test

echo "Generating Docker image contents"
sbt docker:publishLocal

echo "Building docker images for local and dev environments"
pwd
cd ./target/docker/stage
pwd
docker build -t $APP:local .
docker build -t $APP:$VERSION .
