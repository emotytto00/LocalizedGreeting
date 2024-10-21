FROM maven:3.8.5-openjdk-21 AS build

WORKDIR /app

COPY pom.xml /app/

COPY src /app/src/

RUN mvn clean package

FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar /app/LocalizedGreeting-1.0-SNAPSHOT.jar

CMD ["java", "-jar", "LocalizedGreeting-1.0-SNAPSHOT.jar"]