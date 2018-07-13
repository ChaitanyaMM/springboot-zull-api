FROM openjdk:alpine
MAINTAINER chaitanya <chaitanya@eyedentifysystems.com>
ADD target/webservices-api.jar webservices-api.jar
ENTRYPOINT ["java", "-jar", "/webservices-api.jar"]
EXPOSE 8765