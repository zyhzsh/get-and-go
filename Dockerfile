FROM openjdk:11
ADD build/libs/getandgo-1.0-SNAPSHOT.jar getandgo-1.0-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","getandgo-1.0-SNAPSHOT.jar"]

