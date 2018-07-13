FROM openjdk:alpine
MAINTAINER chaitanya <chaitanya@eyedentifysystems.com>
ADD target/gateway-api.jar gateway-api.jar
ENTRYPOINT ["java", "-jar", "/gateway-api.jar"]
EXPOSE 8765