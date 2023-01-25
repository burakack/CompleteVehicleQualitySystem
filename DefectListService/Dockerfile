FROM openjdk:17
ADD DefectListService/target/DefectListService.jar DefectListService.jar
ENV host=postgres
ENTRYPOINT ["java","-jar","/DefectListService.jar"]