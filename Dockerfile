FROM openjdk:17-jdk-oracle
RUN pwd
RUN ls
ENTRYPOINT ["java", "-version"]