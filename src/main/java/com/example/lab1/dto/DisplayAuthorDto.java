package com.example.lab1.dto;

import com.example.lab1.model.domain.Author;
import com.example.lab1.model.domain.Country;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayAuthorDto (
        Long id,
        String name,
        String surname,
        Long country
) {
    public static DisplayAuthorDto from(Author author){
        return new DisplayAuthorDto(
                author.getId(),
                author.getName(),
                author.getSurname(),
                author.getCountry().getId()
        );
    }

    public static List<DisplayAuthorDto> from(List<Author> products) {
        return products.stream().map(DisplayAuthorDto::from).collect(Collectors.toList());
    }

}
