package com.example.lab1.service.domain.impl;

import com.example.lab1.model.domain.Author;
import com.example.lab1.model.domain.Book;
import com.example.lab1.repository.AuthorRepository;
import com.example.lab1.service.domain.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Author> findAll() {
        return null;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Author> update(Long id, Author author) {
        return Optional.empty();
    }

    @Override
    public Optional<Author> save(Author author) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }
}
