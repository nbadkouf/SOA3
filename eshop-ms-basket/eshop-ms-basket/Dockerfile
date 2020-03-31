FROM openjdk:8-jre-alpine

MAINTAINER Nawel Badkouf

WORKDIR /applications2
ADD server.p12 /applications2

COPY target/eshop-ms-basket-1.0.0-SNAPSHOT.jar /applications2/app.jar

ENTRYPOINT ["java", "-jar", "/applications2/app.jar"]
