FROM eclipse-temurin:17-jdk
VOLUME /tmp
ADD target/ms-books-payment-0.0.1-SNAPSHOT.jar /ms-books-payment.jar
RUN chmod +x /ms-books-payment.jar
ENTRYPOINT ["java", "-jar", "/ms-books-payment.jar"]
EXPOSE 8082