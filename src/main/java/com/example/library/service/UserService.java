package com.example.library.service;

import com.example.library.entity.model.User;
import com.example.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<List<User>> getAllUserWithBorrowedOne() {
        return ResponseEntity.ok(userRepository.findAllUsersWithBorrowedBooks());
    }

    public ResponseEntity<List<User>> getAllUserWithoutBorrowedBooks() {
        return ResponseEntity.ok(userRepository.findAllUsersWithoutBorrowedBooks());
    }
}
