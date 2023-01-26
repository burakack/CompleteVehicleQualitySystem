FROM openjdk:17
ADD TerminalService/target/TerminalService.jar TerminalService.jar
ENV host=postgres
ENV DB_PASS=postgres
ENTRYPOINT ["java","-jar","/TerminalService.jar"]