package com.example.springBoot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {
//http://localhost:2021/Books
    @GetMapping("/Books")
    public List<Book> getBooks() {
       return Arrays.asList(new Book(1, "Book1", "author1"), new Book(2, "Book2", "author2"));
    }
}
