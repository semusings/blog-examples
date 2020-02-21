#!/usr/bin/env bash
export KUBE_NAMESPACE=$1
export DEPLOYMENT=$2
helm delete --purge ${KUBE_NAMESPACE}