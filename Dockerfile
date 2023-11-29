FROM openjdk:17-alpine

RUN mkdir app

ADD target/springboot-mysql-docker.jar app

ENTRYPOINT ["java", "-jar", "app/springboot-mysql-docker.jar"]


