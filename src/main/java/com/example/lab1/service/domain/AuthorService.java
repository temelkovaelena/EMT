package com.example.lab1.service.domain;

import com.example.lab1.dto.BookDto;
import com.example.lab1.model.domain.Author;
import com.example.lab1.model.domain.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findById(Long id);

    Optional<Author> update(Long id, Author author);
    Optional<Author> save (Author author);
    void delete(Long id);
}
