#!/usr/bin/env bash
cd order-service
mvn clean package
cd ..

docker-compose up