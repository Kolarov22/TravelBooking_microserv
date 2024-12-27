FROM openjdk:23
ADD target/gateway-0.0.1-SNAPSHOT.jar gateway.jar
RUN sh -c 'touch /gateway.jar'
EXPOSE 8080
ENTRYPOINT ["java","-jar","/gateway.jar"]