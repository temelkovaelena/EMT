package com.example.lab1.service.application.impl;

import com.example.lab1.dto.CreateCountryDto;
import com.example.lab1.dto.DisplayCountryDto;
import com.example.lab1.service.application.CountryApplicationDto;
import com.example.lab1.service.domain.CountryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CountryApplicationServiceImpl implements CountryApplicationDto {

    private final CountryService countryService;

    public CountryApplicationServiceImpl(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public List<DisplayCountryDto> findAll() {
        return countryService.findAll().stream().map(DisplayCountryDto::from).collect(Collectors.toList());
    }

    @Override
    public Optional<DisplayCountryDto> findById(Long id) {
        return countryService.findById(id).map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> update(Long id, CreateCountryDto countryDto) {
        return countryService.update(id,countryDto.toCountry()).map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> save(CreateCountryDto countryDto) {
        return countryService.save(countryDto.toCountry()).map(DisplayCountryDto::from);
    }

    @Override
    public void delete(Long id) {
        countryService.delete(id);
    }
}
