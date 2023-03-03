FROM openjdk:17
ADD DefectEntryService/target/DefectEntryService.jar DefectEntryService.jar
ENV host=postgres
ENV authServiceName=auth-service
ENV DB_PASS=postgres
ENTRYPOINT ["java","-jar","/DefectEntryService.jar"]