package com.example.lab1.service;

import com.example.lab1.model.Author;

import java.util.Optional;

public interface AuthorService {
    Optional<Author> findById(Long id);
}
