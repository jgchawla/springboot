FROM openjdk:8
COPY /target/spring-jenkins-0.0.1-SNAPSHOT.jar /app.jar 
CMD ["java","-jar","app.jar"]