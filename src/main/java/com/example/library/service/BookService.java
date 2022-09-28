package com.example.library.service;

import com.example.library.entity.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public ResponseEntity<List<Book>> getAllAvailableBooks() {
        return ResponseEntity.ok(bookRepository.findAllAvailableBooks());
    }
}
