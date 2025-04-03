package com.example.lab1.service.application.impl;

import com.example.lab1.dto.CreateAuthorDto;
import com.example.lab1.dto.DisplayAuthorDto;
import com.example.lab1.service.application.AuthorApplicationService;
import com.example.lab1.service.domain.AuthorService;

import java.util.List;
import java.util.Optional;

public class AuthorApplicationServiceImpl implements AuthorApplicationService {

    private final AuthorService authorService;

    public AuthorApplicationServiceImpl(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public List<DisplayAuthorDto> findAll() {
        return DisplayAuthorDto.from(authorService.findAll());
    }

    @Override
    public Optional<DisplayAuthorDto> findById(Long id) {
        return authorService.findById(id).map(DisplayAuthorDto::from);
    }

    @Override
    public Optional<DisplayAuthorDto> update(Long id, CreateAuthorDto authorDto) {
        return authorService.update(id,authorDto.toAuthor()).map(DisplayAuthorDto::from);
    }

    @Override
    public Optional<DisplayAuthorDto> save(CreateAuthorDto authorDto) {
        return authorService.save(authorDto.toAuthor()).map(DisplayAuthorDto::from);
    }

    @Override
    public void delete(Long id) {
        authorService.delete(id);
    }
}
