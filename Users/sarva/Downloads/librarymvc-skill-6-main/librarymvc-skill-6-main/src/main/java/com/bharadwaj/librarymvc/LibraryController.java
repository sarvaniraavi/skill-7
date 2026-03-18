package com.bharadwaj.librarymvc;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class LibraryController {

    private List<Book> bookList = new ArrayList<>();

    public LibraryController() {
        // Initial sample books
        bookList.add(new Book(1, "Java Basics", "James Gosling", 499.0));
        bookList.add(new Book(2, "Spring Boot Guide", "Rod Johnson", 599.0));
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System!";
    }

    @GetMapping("/count")
    public int getBookCount() {
        return bookList.size();
    }

    @GetMapping("/price")
    public double getSamplePrice() {
        return 499.99;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookList;
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookList.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book: " + title;
    }

    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by Author: " + name;
    }

    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully!";
    }

    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}
