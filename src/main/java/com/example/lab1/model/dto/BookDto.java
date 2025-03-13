package com.example.lab1.model.dto;

import com.example.lab1.model.Author;
import com.example.lab1.model.Category;
import jakarta.persistence.*;
import lombok.Data;


@Data
public class BookDto {

    private String name;
    private Category category;
    private Long author;
    private Integer availableCopies;

    public BookDto(String name, Category category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
