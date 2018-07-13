FROM openjdk:alpine
MAINTAINER chaitanya <chaitanya@eyedentifysystems.com>
ADD target/eurekaserver-api.jar eurekaserver-api.jar
ENTRYPOINT ["java", "-jar", "/eurekaserver-api.jar"]
EXPOSE 8765