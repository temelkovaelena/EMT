package com.example.lab1.config;

import com.example.lab1.model.domain.Author;
import com.example.lab1.model.domain.Book;
import com.example.lab1.model.domain.User;
import com.example.lab1.model.enumerations.Category;
import com.example.lab1.model.domain.Country;
import com.example.lab1.model.enumerations.Role;
import com.example.lab1.repository.AuthorRepository;
import com.example.lab1.repository.BookRepository;
import com.example.lab1.repository.CountryRepository;
import com.example.lab1.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    private final BookRepository bookRepository;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(AuthorRepository authorRepository, CountryRepository countryRepository, BookRepository bookRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init(){
        Country country1 = countryRepository.save(new Country("CountryName1","Continent1"));
        Country country2 = countryRepository.save(new Country("CountryName2","Continent2"));
        Country country3 = countryRepository.save(new Country("CountryName3","Continent3"));

        Author author1 = authorRepository.save(new Author("AuthorName1","AuthorSurname1",country1));
        Author author2 = authorRepository.save(new Author("AuthorName2","AuthorSurname2",country2));
        Author author3 = authorRepository.save(new Author("AuthorName3","AuthorSurname2",country2));

        bookRepository.save(new Book("BookName1", Category.CLASSICS,author1,3));
        bookRepository.save(new Book("BookName2", Category.DRAMA,author2,4));
        bookRepository.save(new Book("BookName3", Category.THRILLER,author3,5));

        userRepository.save(new User(
                "user",
                passwordEncoder.encode("user"),
                "Elena",
                "Temelkova",
                Role.ROLE_LIBRARIAN
        ));

        userRepository.save(new User(
                "user",
                passwordEncoder.encode("user"),
                "user",
                "user",
                Role.ROLE_USER
        ));
    }
}
