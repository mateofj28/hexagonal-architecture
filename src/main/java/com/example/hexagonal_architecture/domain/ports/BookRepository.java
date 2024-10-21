package com.example.hexagonalarchitecture.domain.ports;

import com.example.hexagonalarchitecture.domain.Book;

import java.util.List;

import java.util.Optional;

public interface BookRepository {
    Book save(Book book);
    List<Book> findAll();
    Optional<Book> findById(Long id);
    void deleteById(Long id);
}

