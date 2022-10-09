FROM maven:3.8.6-openjdk-11 as build
COPY src usr/src/api/src
COPY pom.xml usr/src/api
RUN mvn -f usr/src/api/pom.xml clean package

FROM openjdk:11
EXPOSE 9000
WORKDIR .
COPY --from=build /usr/src/api/target/library_api-0.0.1-SNAPSHOT.jar /usr/api/library_api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/usr/api/library_api-0.0.1-SNAPSHOT.jar"]
