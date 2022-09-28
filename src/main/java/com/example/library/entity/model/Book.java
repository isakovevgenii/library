package com.example.library.entity.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String author;
    private String genre;
    private String publisher;
}
