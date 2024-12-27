FROM openjdk:23
ADD target/reservation-0.0.1-SNAPSHOT.jar reservation.jar
RUN sh -c 'touch /reservation.jar'
EXPOSE 8081
ENTRYPOINT ["java","-jar","/reservation.jar"]
