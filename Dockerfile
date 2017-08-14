FROM debian:latest

RUN apt-get -y update && apt-get install -y openjdk-8-jre vim procps curl

COPY build/libs/elsie-deesight-1.0-SNAPSHOT.jar /ekholabs/elsie-deesight.jar

WORKDIR ekholabs

ENV CONFIGURATION_SERVER_HOST_NAME=configuration-service
ENV CONFIGURATION_SERVER_PORT=8082
EXPOSE $CONFIGURATION_SERVER_PORT

ENTRYPOINT ["java"]
CMD ["-server", "-Xmx256M", "-jar", "elsie-deesight.jar"]
