FROM eclipse-temurin:17-jdk
VOLUME /tmp
ADD target/api-gateway-0.0.1-SNAPSHOT.jar api-gateway.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]