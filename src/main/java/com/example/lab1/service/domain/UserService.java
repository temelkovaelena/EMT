package com.example.lab1.service.domain;


import com.example.lab1.model.domain.Book;
import com.example.lab1.model.domain.User;
import com.example.lab1.model.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);

    User login(String username, String password);

    User findByUsername(String username);

    List<Book> addBookToWhishlist(String username, Long bookId);
    List<Book> getUserWishlist(String username);
}

