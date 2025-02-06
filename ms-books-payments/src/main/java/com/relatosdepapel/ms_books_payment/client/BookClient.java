package com.relatosdepapel.payments.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-books-catalogue")
public interface BookClient {
    @GetMapping("/books/{bookId}")
    Book getBookById(@PathVariable String bookId);
}