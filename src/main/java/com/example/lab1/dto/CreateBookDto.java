package com.example.lab1.dto;

import com.example.lab1.model.domain.Author;
import com.example.lab1.model.domain.Book;
import com.example.lab1.model.enumerations.Category;

public record CreateBookDto(String name, Category category, Author author, Integer availableCopies) {
    public Book toBook(Category category,Author author){
        return new Book(name,category,author,availableCopies);
    }
}
