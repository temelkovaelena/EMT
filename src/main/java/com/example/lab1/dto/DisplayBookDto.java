package com.example.lab1.dto;

import com.example.lab1.model.domain.Author;
import com.example.lab1.model.domain.Book;
import com.example.lab1.model.enumerations.Category;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayBookDto(
        Long id,
        String name,
        String category,
        Long author,
        Integer availableCopies) {
    public static DisplayBookDto from(Book book) {
        return new DisplayBookDto(
                book.getId(),
                book.getName(),
                book.getCategory().name(),
                book.getAuthor().getId(),
                book.getAvailableCopies()
        );
    }

    public static List<DisplayBookDto> from(List<Book> books) {
        return books.stream().map(DisplayBookDto::from).collect(Collectors.toList());
    }



}
