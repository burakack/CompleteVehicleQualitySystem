FROM openjdk:17
ADD AuthService/target/AuthService.jar AuthService.jar
ENV host=postgres
ENTRYPOINT ["java","-jar","/AuthService.jar"]