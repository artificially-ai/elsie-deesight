FROM debian:latest

RUN apt-get -y update && apt-get install -y openjdk-8-jre-headless openjdk-8-jdk maven git vim procps

WORKDIR ekholabs

RUN git clone https://github.com/ekholabs/elsie-deesight
WORKDIR elsie-deesight
RUN ./gradlew clean build

ENV ELSIE_DEESIGHT_PORT=8085

EXPOSE $ELSIE_DEESIGHT_PORT

ENTRYPOINT ["java"]
CMD ["-server", "-Xmx256M", "-jar", "build/libs/elsie-deesight-1.0-SNAPSHOT.jar"]
