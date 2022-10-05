FROM openjdk:11
EXPOSE 8080
WORKDIR .
COPY target/library_api-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "library_api-0.0.1-SNAPSHOT.jar"]
