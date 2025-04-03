package com.example.lab1.service.domain;

import com.example.lab1.model.domain.Book;
import com.example.lab1.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);

    Optional<Book> update(Long id, Book book);
    Optional<Book> save (Book book);
    void delete(Long id);
    Optional<Book> rentBook(Long id);
}
