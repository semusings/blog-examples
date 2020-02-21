#!/usr/bin/env bash

KUBE_NAMESPACE=$1
DEPLOYMENT=$2

for p in $(kubectl get pods --namespace ${KUBE_NAMESPACE} | grep ^${DEPLOYMENT} | cut -f 1 -d ' '); do
    echo ---------------------------
    echo ${p}
    echo ---------------------------
    kubectl describe pod ${p} --namespace ${KUBE_NAMESPACE}
done