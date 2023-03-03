FROM openjdk:17
ADD AuthService/target/AuthService.jar AuthService.jar
ENV resthost=appnetwork
ENV host=postgres
ENV DB_PASS=postgres
ENTRYPOINT ["java","-jar","/AuthService.jar"]