package com.example.lab1.service.application;

import com.example.lab1.dto.CreateAuthorDto;
import com.example.lab1.dto.CreateBookDto;
import com.example.lab1.dto.DisplayAuthorDto;
import com.example.lab1.dto.DisplayBookDto;

import java.util.List;
import java.util.Optional;

public interface BookApplicationService {
    List<DisplayBookDto> findAll();
    Optional<DisplayBookDto> findById(Long id);

    Optional<DisplayBookDto> update(Long id, CreateBookDto bookDto);
    Optional<DisplayBookDto> save ( CreateBookDto bookDto);
    void delete(Long id);
}
