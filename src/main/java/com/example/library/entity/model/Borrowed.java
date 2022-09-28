package com.example.library.entity.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "borrowed")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Borrowed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String firstName;
    private String book;
    private LocalDate borrowedFrom;
    private LocalDate borrowedTo;
}
