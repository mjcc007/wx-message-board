FROM openjdk:11.0.1-jre-slim-stretch
MAINTAINER mjcc
ARG JAR_FILE
# EXPOSE 6050
ADD target/${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=docker"]
