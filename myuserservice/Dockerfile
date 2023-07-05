FROM openjdk:11
EXPOSE 7071
ADD target/userservice_docker.jar userservice_docker.jar
ENTRYPOINT [ "java","-jar","/userservice_docker.jar"]