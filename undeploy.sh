#!/bin/sh

kubectl delete service,deployment,configmap authenteq-greeting --namespace authenteq-greeting || exit 1
kubectl delete clusterrolebinding authenteq-greeting:default || exit 1
kubectl delete namespace authenteq-greeting || exit 1

minikube cache delete docker.authenteq.com/authenteq-greeting:0.1.0-SNAPSHOT
