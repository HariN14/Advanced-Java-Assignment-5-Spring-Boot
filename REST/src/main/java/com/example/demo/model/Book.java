package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookData")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "author")
    private String author;

    /*@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;*/
    @Column(name = "date")
    private String date;

}
