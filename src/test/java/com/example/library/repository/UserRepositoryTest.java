package com.example.library.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void findAllUsersTest() {
        Iterable users = userRepository.findAll();
        assertThat(users).hasSize(11);
    }

    @Test
    public void findAllUsersWithBorrowedBooksTest() {
        Iterable users = userRepository.findAllUsersWithBorrowedBooks();
        assertThat(users).hasSize(0);
    }

    @Test
    public void findAllUsersWithoutBorrowedBooksTest() {
        Iterable users = userRepository.findAllUsersWithoutBorrowedBooks();
        assertThat(users).hasSize(11);
    }
}