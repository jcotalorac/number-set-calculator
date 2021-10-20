# Build stage
FROM maven:3.8.3-openjdk-11 AS build
COPY pom.xml /app/
COPY src/ /app/src/
RUN mvn -f /app/pom.xml clean package verify
