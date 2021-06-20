FROM openjdk:11-jre-slim
ADD build/libs/getandgo-1.0-SNAPSHOT.jar getandgo-1.0-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","getandgo-1.0-SNAPSHOT.jar"]