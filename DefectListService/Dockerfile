FROM openjdk:17
ADD DefectListService/target/DefectListService.jar DefectListService.jar
ENV host=postgres
ENV authServiceName=auth-service
ENV DB_PASS=postgres
ENTRYPOINT ["java","-jar","/DefectListService.jar"]