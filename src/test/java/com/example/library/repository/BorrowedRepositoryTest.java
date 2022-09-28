package com.example.library.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BorrowedRepositoryTest {

    @Autowired
    BorrowedRepository borrowedRepository;

    @Test
    public void findAllBooksTest() {
        Iterable borrowedBooks = borrowedRepository.findAll();
        assertThat(borrowedBooks).hasSize(119);
    }
}
