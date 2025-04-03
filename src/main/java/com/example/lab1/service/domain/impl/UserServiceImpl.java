package com.example.lab1.service.domain.impl;


import com.example.lab1.model.domain.Book;
import com.example.lab1.model.domain.User;
import com.example.lab1.model.enumerations.Role;
import com.example.lab1.repository.UserRepository;
import com.example.lab1.service.domain.BookService;
import com.example.lab1.service.domain.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final BookService bookService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, BookService bookService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.bookService = bookService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                username));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                username));
    }

    @Override
    public List<Book> addBookToWhishlist(String username, Long bookId) {
        Book book = bookService.findById(bookId).get();
        User user = findByUsername(username);
        if(book.getAvailableCopies()>0){
            user.getWishlistedBooks().add(book);
            userRepository.save(user);
            return user.getWishlistedBooks();
        }
        throw new RuntimeException("No available copies");
    }

    @Override
    public List<Book> getUserWishlist(String username) {
        return userRepository.findByUsername(username).get().getWishlistedBooks();
    }

    @Override
    public User register(
            String username,
            String password,
            String repeatPassword,
            String name,
            String surname,
            Role userRole
    ) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new RuntimeException("Username or password cannot be empty");
        if (!password.equals(repeatPassword)) throw new RuntimeException("Passwords do not match");
        if (userRepository.findByUsername(username).isPresent())
            throw new RuntimeException("Username is not available");
        User user = new User(username, passwordEncoder.encode(password), name, surname, userRole);
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new RuntimeException("Username or password cannot be empty");
        }
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(RuntimeException::new);
    }
}