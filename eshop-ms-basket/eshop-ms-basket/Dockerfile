FROM openjdk:8-jre-alpine

MAINTAINER Nawel Badkouf

WORKDIR /applications
ADD server.p12 /applications

COPY eshop-ms-basket-1.0.0-SNAPSHOT.jar /applications/app.jar

ENTRYPOINT["java", "-jar", "/applications/app.jar"]