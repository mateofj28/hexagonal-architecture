package com.example.hexagonalarchitecture.infrastructure.controller;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

import com.example.hexagonalarchitecture.application.BookService;
import com.example.hexagonalarchitecture.domain.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book.getTitle(), book.getAuthor());
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> optionalBook = bookService.getBookById(id); // Cambia según tu lógica
        return optionalBook.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); // Si no se encuentra
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}

