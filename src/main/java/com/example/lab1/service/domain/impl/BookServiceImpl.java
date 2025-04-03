package com.example.lab1.service.domain.impl;

import com.example.lab1.model.domain.Book;
import com.example.lab1.dto.BookDto;
import com.example.lab1.repository.AuthorRepository;
import com.example.lab1.repository.BookRepository;
import com.example.lab1.service.domain.AuthorService;
import com.example.lab1.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> update(Long id, Book bookDto) {
        Book book = this.findById(id).get();
        if (bookDto.getAuthor() != null) {
            book.setAuthor(authorService.findById(bookDto.getAuthor().getId()).get());
        }
        if (bookDto.getCategory() != null) {
            book.setCategory(bookDto.getCategory());
        }
        if (bookDto.getAvailableCopies() != null) {
            book.setAvailableCopies(bookDto.getAvailableCopies());
        }
        if (bookDto.getName() != null) {
            book.setName(bookDto.getName());
        }
        return Optional.of(this.bookRepository.save(book));
    }


    @Override
    public Optional<Book> save(Book book) {
        if(book.getName() !=null &&
                authorService.findById(book.getAuthor().getId()).isPresent() &&
                book.getCategory() !=null &&
                book.getAvailableCopies() !=null
        ){
            return Optional.of(
                    bookRepository.save(new Book(book.getName(),book.getCategory(),authorService.findById(book.getAuthor().getId()).get(),book.getAvailableCopies()))
            );
        }
        return Optional.empty();
    }



    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }


    public Optional<Book> rentBook(Long id) {
        return bookRepository.findById(id).map(b -> {
            if (b.getAvailableCopies() > 0) {
                b.setAvailableCopies(b.getAvailableCopies() - 1);
            } else {
                throw new RuntimeException("No available copies to rent.");
            }
            return bookRepository.save(b);
        });
    }
}
