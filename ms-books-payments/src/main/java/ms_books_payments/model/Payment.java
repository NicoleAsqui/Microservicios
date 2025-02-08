package ms_books_payments.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID del libro no puede ser nulo")
    private Long bookId;

    @NotNull(message = "El precio no puede ser nulo")
    @Min(value = 0, message = "El precio no puede ser negativo")
    private Double price;

    @NotNull(message = "La fecha de compra no puede ser nula")
    private LocalDateTime purchaseDate;

    public Payment() {
        this.purchaseDate = LocalDateTime.now();
    }
}
