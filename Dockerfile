FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD ./target/authorizationService-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar"]