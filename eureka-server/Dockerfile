FROM eclipse-temurin:17-jdk
VOLUME /tmp
ADD target/eureka-server-0.0.1-SNAPSHOT.jar eureka-server.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]