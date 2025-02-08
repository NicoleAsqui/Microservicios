package ms_books_payments.client;

import ms_books_payments.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-books-catalogue")
public interface BookClient {
    @GetMapping("/api/books/{bookId}")
    Book getBookById(@PathVariable String bookId);
}