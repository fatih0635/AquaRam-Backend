# 1. Maven ile build için geçici image
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 2. Final image
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/aqua-ram-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
