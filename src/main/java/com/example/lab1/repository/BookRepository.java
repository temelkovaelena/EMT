package com.example.lab1.repository;

import com.example.lab1.model.Book;
import com.example.lab1.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
