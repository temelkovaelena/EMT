package com.example.lab1.model.domain;

import com.example.lab1.model.enumerations.Category;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    private Author author;
    private Integer availableCopies;

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Book() {

    }
}
    /*id (Long), name (String), category (enum), author (Author), availableCopies (Integer)*/
