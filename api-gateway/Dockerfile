FROM ubuntu:latest
FROM openjdk

LABEL authors="Ashish"

COPY target/*.jar /api-gateway-service.jar

EXPOSE 9000

ENTRYPOINT ["java", "-jar", "/api-gateway-service.jar"]