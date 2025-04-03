package com.example.lab1.service.application;

import com.example.lab1.dto.CreateAuthorDto;
import com.example.lab1.dto.DisplayAuthorDto;
import com.example.lab1.model.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorApplicationService {

    List<DisplayAuthorDto> findAll();
    Optional<DisplayAuthorDto> findById(Long id);

    Optional<DisplayAuthorDto> update(Long id, CreateAuthorDto authorDto);
    Optional<DisplayAuthorDto> save (CreateAuthorDto authorDto);
    void delete(Long id);
}
