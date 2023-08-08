FROM ubuntu:latest
FROM openjdk

LABEL authors="Ashish"

COPY target/*.jar /booking-app-service.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/booking-app-service.jar"]