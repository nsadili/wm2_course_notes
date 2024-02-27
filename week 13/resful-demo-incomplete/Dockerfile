FROM openjdk:17
EXPOSE 8080
ARG JAR_FILE=target/restful-spring.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]