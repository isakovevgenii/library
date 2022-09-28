package com.example.library.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void findAllBooksTest() {
        Iterable books = bookRepository.findAll();
        assertThat(books).hasSize(111);
    }

    @Test
    public void findAllUsersWithBorrowedBooksTest() {
        Iterable books = bookRepository.findAllAvailableBooks();
        assertThat(books).hasSize(111);
    }
}
