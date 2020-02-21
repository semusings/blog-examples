#!/usr/bin/env bash

set -e

function db() {
    docker run -d -v "$PWD":/dynamodb_local_db -p 8000:8000 \
        --network lambda-local --name dynamodb amazon/dynamodb-local
}

function serve() {
    serverless --stage local sam export --output ./template.yml
    AWS_REGION=us-east-1 sam local start-lambda --docker-network lambda-local
}

function verify() {
    sam local invoke OrderManagerApiLocalReceiveOrder -e event.json
    sam local invoke  OrderManagerApiLocalGetOrders -e event.json
}

function usage() {
    echo "Usage: $(basename $0) <command> [<args>]"
    echo -e
    echo "Available commands:"
    echo "  serve          Start Local Lambda"
    echo "  build          Prepare Lambda Artifact"
    echo "  verify         Verify Lambda Functions"
    echo "  db             Launch Dynamo Database"
    echo -e
}

function requires() {
    local command=$1
    which ${command} > /dev/null 2>&1 || { echo "!! This script requires [${command}] to be installed" && exit 1; }
}

requires 'docker'
requires 'sam'

command=$1; shift
case "${command}" in
    serve)
        serve
        ;;
    build)
        ./gradlew clean build
        ;;
    verify)
        verify
        ;;
    db)
        db
        ;;
    *)
        usage
        exit 1
       ;;
esac