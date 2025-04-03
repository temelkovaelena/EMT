package com.example.lab1.service.application;

import com.example.lab1.dto.CreateAuthorDto;
import com.example.lab1.dto.CreateCountryDto;
import com.example.lab1.dto.DisplayAuthorDto;
import com.example.lab1.dto.DisplayCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationDto {
    List<DisplayCountryDto> findAll();
    Optional<DisplayCountryDto> findById(Long id);

    Optional<DisplayCountryDto> update(Long id, CreateCountryDto countryDto);
    Optional<DisplayCountryDto> save (CreateCountryDto countryDto);
    void delete(Long id);
}
