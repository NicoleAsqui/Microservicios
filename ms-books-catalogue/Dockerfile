FROM eclipse-temurin:17-jdk
VOLUME /tmp
ADD target/ms-books-catalogue-0.0.1-SNAPSHOT.jar ms-books-catalogue.jar
RUN chmod +x /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]