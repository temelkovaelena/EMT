package com.example.lab1.dto;

import com.example.lab1.model.domain.Author;
import com.example.lab1.model.domain.Country;

public record CreateAuthorDto(String name, String surname, Country country) {

    public Author toAuthor(){
        return new Author(name,surname,country);
    }
}
