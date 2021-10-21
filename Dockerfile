# Build stage
FROM maven:3.8.3-openjdk-11 AS build
COPY pom.xml /app/
COPY src/ /app/src/
RUN mvn -f /app/pom.xml clean package verify

# Run stage
FROM openjdk:11-jre-slim
EXPOSE 8080
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "/app.jar"]