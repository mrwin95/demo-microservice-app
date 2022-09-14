#FROM adoptopenjdk/openjdk16
FROM eclipse-temurin:18-focal
ARG JAR_FILE=target/*.jar
COPY $JAR_FILE cloud-naming-svc.jar
ENTRYPOINT ["java", "-jar", "cloud-naming-svc.jar"]
EXPOSE 8761