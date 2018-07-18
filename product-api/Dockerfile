FROM openjdk:alpine
#openjdk:8-jdk-alpine
MAINTAINER chaitanya <chaitanya@eyedentifysystems.com>
ADD target/product-api.jar product-api.jar
ENTRYPOINT ["java", "-jar", "/product-api.jar"]
EXPOSE 8765