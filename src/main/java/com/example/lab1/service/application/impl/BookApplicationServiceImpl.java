package com.example.lab1.service.application.impl;

import com.example.lab1.dto.CreateBookDto;
import com.example.lab1.dto.DisplayBookDto;
import com.example.lab1.model.domain.Author;
import com.example.lab1.model.enumerations.Category;
import com.example.lab1.service.application.BookApplicationService;
import com.example.lab1.service.domain.AuthorService;
import com.example.lab1.service.domain.BookService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookApplicationServiceImpl implements BookApplicationService {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookApplicationServiceImpl(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public List<DisplayBookDto> findAll() {
        return bookService.findAll().stream().map(DisplayBookDto::from).collect(Collectors.toList());
    }

    @Override
    public Optional<DisplayBookDto> findById(Long id) {
        return bookService.findById(id).map(DisplayBookDto::from);
    }

    @Override
    public Optional<DisplayBookDto> update(Long id, CreateBookDto bookDto) {
        Optional<Author> author = authorService.findById(bookDto.author().getId());
        Category category = Category.valueOf(bookDto.category().name());


        return bookService.update(id,bookDto.toBook(category,author.get())).map(DisplayBookDto::from);
    }

    @Override
    public Optional<DisplayBookDto> save(CreateBookDto bookDto) {
        Optional<Author> author = authorService.findById(bookDto.author().getId());
        Category category = Category.valueOf(bookDto.category().name());

        return bookService.save(bookDto.toBook(category,author.get())).map(DisplayBookDto::from);
    }

    @Override
    public void delete(Long id) {
        bookService.delete(id);
    }
}
