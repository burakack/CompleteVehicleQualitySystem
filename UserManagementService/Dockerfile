FROM openjdk:17
ADD UserManagementService/target/UserManagementService.jar UserManagementService.jar
ENV host=postgres
ENTRYPOINT ["java","-jar","/UserManagementService.jar"]