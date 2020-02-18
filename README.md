# Greeting Application

## Run using Maven

Run `./run.sh` to run the application locally using the 
[Spring Boot Maven Plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-running-with-the-maven-plugin).

## Run in Docker

Run `docker-compose up` to run the application in [Docker](https://docs.docker.com/install/) using 
[Docker Compose](https://docs.docker.com/compose/).

Please read the Docker documentation about how to install Docker and Docker Compose.

## Run in Kubernetes

Run `./build-and-deploy.sh` to build and deploy the application into the local 
[minikube](https://minikube.sigs.k8s.io/docs/) cluster.

Run `./undeploy.sh` to undeploy the application then.

Please read the minikube documentation about how to install it.
