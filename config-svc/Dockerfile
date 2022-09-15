#FROM adoptopenjdk/openjdk16
FROM eclipse-temurin:18-focal
ARG JAR_FILE=target/*.jar
COPY $JAR_FILE config-svc.jar
ENTRYPOINT ["java", "-jar", "config-svc.jar"]
EXPOSE 8888