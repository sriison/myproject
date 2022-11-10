FROM openjdk:8
ARG JAR_FILE=target/spring-backend-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} application.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","application.jar"]

