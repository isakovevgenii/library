package com.example.library.repository;

import com.example.library.entity.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT * from public.book b\n" +
            "    where b.title not in (SELECT book FROM public.borrowed WHERE borrowed_from < now() and borrowed_to > now());",
            nativeQuery = true)
    List<Book> findAllAvailableBooks();

}
