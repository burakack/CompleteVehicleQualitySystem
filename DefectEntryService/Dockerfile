FROM openjdk:17
ADD DefectEntryService/target/DefectEntryService.jar DefectEntryService.jar
ENV host=postgres
ENV DB_PASS=postgres
ENTRYPOINT ["java","-jar","/DefectEntryService.jar"]