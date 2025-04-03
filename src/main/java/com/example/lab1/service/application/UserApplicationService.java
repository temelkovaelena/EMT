package com.example.lab1.service.application;

import com.example.lab1.dto.CreateUserDto;
import com.example.lab1.dto.DisplayBookDto;
import com.example.lab1.dto.DisplayUserDto;
import com.example.lab1.dto.LoginUserDto;

import java.util.List;
import java.util.Optional;

public interface UserApplicationService {
    Optional<DisplayUserDto> register(CreateUserDto createUserDto);

    Optional<DisplayUserDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);

    List<DisplayBookDto> addBookToWhishlist(String username, Long bookId);
    List<DisplayBookDto> getUserWishlist(String username);

}
