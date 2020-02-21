#!/usr/bin/env bash
export KUBE_NAMESPACE=$1
export DEPLOYMENT=$2
read -p "Kube Api Endpoint: "
export KUBE_API_ENDPOINT=$REPLY
helm upgrade \
--install \
--force \
--set ingress.hosts[0]=api.order-service.${KUBE_API_ENDPOINT} \
--set ingress.tls[0].hosts[0]=api.order-service.${KUBE_API_ENDPOINT} \
--set ingress.tls[0].secretName=order-service-tls-cert \
--namespace=${KUBE_NAMESPACE} \
${KUBE_NAMESPACE}  \
helm/${DEPLOYMENT}
