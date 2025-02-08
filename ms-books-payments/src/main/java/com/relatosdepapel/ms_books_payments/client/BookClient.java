package com.relatosdepapel.ms_books_payments.client;

import com.relatosdepapel.ms_book_payment.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-books-catalogue", url = "lb://ms-books-catalogue")
public interface BookClient {
    @GetMapping("/api/books/{bookId}")
    Book getBookById(@PathVariable String bookId);
}