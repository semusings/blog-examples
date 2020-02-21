#!/usr/bin/env bash

set -e
#read -p "AWS Region: "
export AWS_REGION=us-east-1

APP_NAME=order-manager-service
STACK_NAME=${APP_NAME}-stack

function package() {
    sam package \
       --template-file api.sam.yml \
       --output-template-file serverless-output-api.yml \
       --s3-bucket ${APP_NAME}
}


function deploy() {
    sam deploy \
       --template-file serverless-output-api.yml \
       --stack-name "${STACK_NAME}" \
       --parameter-overrides $(cat parameters-dev.properties) \
       --capabilities CAPABILITY_IAM
}

function logs() {
    sam logs -n $2 --stack-name ${STACK_NAME} --tail
}

function down() {
    aws cloudformation delete-stack --stack-name ${STACK_NAME}
}

function usage() {
    echo "Usage: $(basename $0) <command> [<args>]"
    echo -e
    echo "Available commands:"
    echo "  package       Create Packaged SAM"
    echo "  down          Delete Stack"
    echo "  deploy        Deploy Lambda"
    echo "  logs          Get Log"
    echo -e
}

function requires() {
    local command=$1
    which ${command} > /dev/null 2>&1 || { echo "!! This script requires [${command}] to be installed" && exit 1; }
}

requires 'aws'
requires 'sam'

command=$1; shift
case "${command}" in
    package)
        package
        ;;
    down)
        down
        ;;
    deploy)
        deploy
        ;;
    logs)
        logs
        ;;
    *)
        usage
        exit 1
       ;;
esac