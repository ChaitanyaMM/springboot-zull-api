FROM openjdk:8-jre-alpine
MAINTAINER chaitanya <chaitanya@eyedentifysystems.com>
ADD target/webservices-api.jar webservices-api.jar
ENTRYPOINT ["java", "-jar", "/webservices-api.jar"]
EXPOSE 3333