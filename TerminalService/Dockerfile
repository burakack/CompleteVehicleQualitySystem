FROM openjdk:17
ADD TerminalService/target/TerminalService.jar TerminalService.jar
ENV host=postgres
ENTRYPOINT ["java","-jar","/TerminalService.jar"]