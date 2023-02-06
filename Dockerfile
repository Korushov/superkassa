FROM openjdk:17
ADD /target/superkassa-0.0.1-SNAPSHOT.jar superkassa.jar
ENTRYPOINT ["java", "-jar", "superkassa.jar"]

EXPOSE 8080/tcp