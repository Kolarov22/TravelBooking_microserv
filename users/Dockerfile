FROM openjdk:23
ADD target/users-0.0.1-SNAPSHOT.jar users.jar
RUN sh -c 'touch /users.jar'
EXPOSE 8082
ENTRYPOINT ["java","-jar","/users.jar"]