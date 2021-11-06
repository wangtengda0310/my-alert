FROM openjdk:17-jdk-oracle
ADD target/my-alert-0.1.0-SNAPSHOT.jar ~
RUN pwd
RUN ls
ENTRYPOINT ["java", "-jar", "~/my-alert-0.1.0-SNAPSHOT.jar"]