FROM debian:latest

RUN apt-get -y update && apt-get install -y openjdk-8-jre-headless openjdk-8-jdk maven git vim procps

COPY build/libs/elsie-deesight-1.0-SNAPSHOT.jar /ekholabs/elsie-deesight.jar

WORKDIR ekholabs

ENV ELSIE_DEESIGHT_PORT=8085
ENV CONFIGURATION_SERVER_HOST_NAME=configuration-service
EXPOSE $ELSIE_DEESIGHT_PORT

ENTRYPOINT ["java"]
CMD ["-server", "-Xmx256M", "-jar", "elsie-deesight.jar"]
