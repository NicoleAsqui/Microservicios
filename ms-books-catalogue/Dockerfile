FROM eclipse-temurin:17-jdk
VOLUME /tmp
ADD target/ms-books-catalogue-0.0.1-SNAPSHOT.jar /ms-books-catalogue.jar
RUN chmod +x /ms-books-catalogue.jar
ENTRYPOINT ["java", "-jar", "/ms-books-catalogue.jar"]
EXPOSE 8081