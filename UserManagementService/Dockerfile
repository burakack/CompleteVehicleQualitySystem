FROM openjdk:17
ADD UserManagementService/target/UserManagementService.jar UserManagementService.jar
ENV host=postgres
ENV DB_PASS=postgres
ENTRYPOINT ["java","-jar","/UserManagementService.jar"]