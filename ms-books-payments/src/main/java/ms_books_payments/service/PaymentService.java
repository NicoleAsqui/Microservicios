package ms_books_payments.service;

import com.relatosdepapel.ms_books_payments.model.Payment;
import com.relatosdepapel.ms_books_payments.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String BOOKS_CATALOGUE_URL = "lb://ms-books-catalogue/api/books";

    public Payment createPayment(Payment payment) {
    String bookUrl = BOOKS_CATALOGUE_URL + "/" + payment.getBookId();
    try {
        restTemplate.getForObject(bookUrl, Object.class);
        System.out.println("Conexión exitosa con el catálogo de libros.");
        return paymentRepository.save(payment);
    } catch (Exception e) {
        throw new RuntimeException("Error al conectar con el catálogo de libros.");
    }
}

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
