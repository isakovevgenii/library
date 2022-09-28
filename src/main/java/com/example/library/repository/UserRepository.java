package com.example.library.repository;

import com.example.library.entity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * from public.library_user lu\n" +
            "    where lu.name in (SELECT name FROM public.borrowed WHERE borrowed_from < now() and borrowed_to > now())\n" +
            "    and lu.first_name in (SELECT first_name FROM public.borrowed WHERE borrowed_from < now() and borrowed_to > now());\n",
            nativeQuery = true)
    List<User> findAllUsersWithBorrowedBooks();


    @Query(value = "SELECT * from public.library_user lu\n" +
            "    where lu.name not in (SELECT name FROM public.borrowed WHERE borrowed_from < now() and borrowed_to > now())\n" +
            "    or lu.first_name not in (SELECT first_name FROM public.borrowed WHERE borrowed_from < now() and borrowed_to > now());",
            nativeQuery = true)
    List<User> findAllUsersWithoutBorrowedBooks();
}
