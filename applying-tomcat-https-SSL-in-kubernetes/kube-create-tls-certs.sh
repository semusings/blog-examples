#!/usr/bin/env bash
export DEPLOYMENT=$1
kubectl create secret tls ${DEPLOYMENT}-tls-cert \
        --key ./docker/conf/ssl.key \
        --cert ./docker/conf/ssl.crt