FROM debian:latest

RUN apt-get -y update && apt-get install -y openjdk-8-jre vim procps curl

COPY build/libs/elsie-deesight-1.0-SNAPSHOT.jar /ekholabs/elsie-deesight.jar

WORKDIR ekholabs

ENV CONFIGURATION_SERVER_HOST_NAME=configuration-service
ENV EUREKA_SERVICE_HOST_NAME=eureka-service
ENV CONFIGURATION_SERVER_PORT=8082
ENV EUREKA_SERVICE_PORT=8083

ENTRYPOINT ["java"]
CMD ["-server", "-Xmx256M", "-jar", "elsie-deesight.jar"]
