package com.example.hexagonalarchitecture.infrastructure.repository;

import com.example.hexagonalarchitecture.domain.Book;
import com.example.hexagonalarchitecture.domain.ports.BookRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaBookRepository extends BookRepository, JpaRepository<Book, Long>  {

    @Override
    default Book save(Book book) {
        Book entity = new Book(null, book.getTitle(), book.getAuthor());
        Book savedEntity = save(entity);
        return new Book(savedEntity.getId(), savedEntity.getTitle(), savedEntity.getAuthor());
    }

    @Override
    default List<Book> findAll() {
        return findAll().stream()
            .map(entity -> new Book(entity.getId(), entity.getTitle(), entity.getAuthor()))
            .toList();
    }

    @Override
    default Optional<Book> findById(Long id) {
        Optional<Book> entity = findById(id); 

        return entity.map(e -> new Book(e.getId(), e.getTitle(), e.getAuthor()));
    }


    @Override
    default void deleteById(Long id) {
        deleteById(id);
    }
}

