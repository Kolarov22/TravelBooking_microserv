FROM openjdk:23
ADD target/discovery-0.0.1-SNAPSHOT.jar discovery.jar
RUN sh -c 'touch /discovery.jar'
EXPOSE 8761
ENTRYPOINT ["java","-jar","/discovery.jar"]