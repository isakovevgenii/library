package com.example.library.controller;

import com.example.library.entity.model.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * Endpoint that returns all books borrowed by a given user in a given date range.
     *
     * @return json with all borrowed books
     */
    @GetMapping("/borrowedBooks")
    public ResponseEntity<List<Book>> getAllBorrowedBooks() {
        return null;
    }

    /**
     * Endpoint that returns all available (not borrowed) books.
     *
     * @return json with all available books
     */
    @GetMapping("/availableBooks")
    public ResponseEntity<List<Book>> getAllAvailableBooks() {
        return bookService.getAllAvailableBooks();
    }
}
