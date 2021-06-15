ADD build/libs/getandgo-1.0-SNAPSHOT.jar getandgo-1.0-SNAPSHOT.jar
FROM openjdk:11-jre-slim
EXPOSE 8080
ENTRYPOINT ["java","-jar","getandgo-1.0-SNAPSHOT.jar"]

