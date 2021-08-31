FROM openjdk:8
ADD target/application-service-registry.jar application-service-registry.jar
EXPOSE 8761
ENTRYPOINT ["java" ,"-jar" ,"application-service-registry.jar"]
