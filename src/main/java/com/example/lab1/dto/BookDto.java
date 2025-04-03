package com.example.lab1.dto;

import com.example.lab1.model.enumerations.Category;
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
