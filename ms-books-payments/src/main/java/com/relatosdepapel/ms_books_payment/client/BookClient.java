package com.relatosdepapel.ms_book_payment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-books-catalog")
public interface BookClient {
    @GetMapping("/books/{bookId}")
    Book getBookById(@PathVariable String bookId);
}