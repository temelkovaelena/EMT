package com.example.lab1.web;

import com.example.lab1.model.domain.Book;
import com.example.lab1.dto.BookDto;
import com.example.lab1.service.domain.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Get all books", description = "Retrieves a list of all available books.")
    @GetMapping
    public List<Book> findAllBooks() {
        return bookService.findAll();
    }

    @Operation(summary = "Get book by ID", description = "Finds a book by its ID.")
    @GetMapping("/{id}")
    public Optional<Book> getBook(@PathVariable Long id){
        return bookService.findById(id);
    }

    @Operation( summary = "Add a new book",
            description = "Creates a new book.")
    @PostMapping("/add")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        return bookService.save(book).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a book", description = "Deletes a book by its ID.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable Long id){
        if (bookService.findById(id).isPresent()) {
            bookService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Update an existing product", description = "Updates a book by ID" )

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> update (@PathVariable Long id, @RequestBody Book book) {
        return bookService.update(id,book).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation
    @PutMapping("/rent/{id}")
    public ResponseEntity<Book> rentBook(@PathVariable Long id) {
        return bookService.rentBook(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
