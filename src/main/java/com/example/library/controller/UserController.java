package com.example.library.controller;

import com.example.library.entity.model.User;
import com.example.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controllers class. Contains all endpoints for the user.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Endpoint that returns all users who have actually borrowed at least one book.
     *
     * @return json with all necessary users
     */
    @GetMapping("/borrowedOne")
    public ResponseEntity<List<User>> getAllUserWithBorrowedOne() {
        return userService.getAllUserWithBorrowedOne();
    }

    /**
     * Endpoint that returns all non-terminated users who have not currently borrowed anything.
     *
     * @return json with all necessary users
     */
    @GetMapping("/notBorrowedAnything")
    public ResponseEntity<List<User>> getAllUserNotBorrowedAnything() {
        return userService.getAllUserWithoutBorrowedBooks();
    }

    /**
     * Endpoint that returns all users who have borrowed a book on a given date.
     *
     * @return json with all necessary users
     */
    @GetMapping("/givenDate")
    public ResponseEntity<List<User>> getAllUserWithBorrowedGivenDate() {
        return null;
    }
}
