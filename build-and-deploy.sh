#!/bin/sh

echo "\nBuilding...\n"

./mvnw package dockerfile:build || exit 1

echo "\nDeploying...\n"

minikube cache add docker.authenteq.com/authenteq-greeting:0.1.0-SNAPSHOT || exit 1
minikube cache reload || exit 1

kubectl apply -f deployment.yaml || exit 1

echo "\nStarting...\n"

URL=$(minikube service authenteq-greeting -n authenteq-greeting --url --wait=2 --interval=1) || exit 1

timeout -s TERM 30 \
    bash -c 'while [[ "$(curl -s -o /dev/null -L -w "%{http_code}" "$0")" != "200" ]]; do sleep 2; done' "$URL" \
    || exit 1

open "$URL" 2>/dev/null \
    || xdg-open "$URL" 2>/dev/null \
    || sensible-browser "$URL" 2>/dev/null \
    || x-www-browser "$URL" 2>/dev/null \
    || gnome-open "$URL" 2>/dev/null \
    || echo "Open in your browser $URL\n"

echo "Done.\n"
