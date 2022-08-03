FROM openjdk:11
EXPOSE 8080
ADD target/url-tool-service.jar url-tool-service.jar
ENTRYPOINT ["java","-jar","/url-tool-service.jar"]
