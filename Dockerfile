FROM openjdk:17-alpine

COPY build/libs/restapikotlin-0.0.1-SNAPSHOT.jar /app/application.jar

CMD ["java", "-jar", "/app/application.jar"]