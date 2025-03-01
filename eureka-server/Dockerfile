FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/eureka-server-0.0.1-SNAPSHOT.jar /app/app.jar
RUN chmod +x /app/app.jar
RUN ls -l /app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
EXPOSE 8761