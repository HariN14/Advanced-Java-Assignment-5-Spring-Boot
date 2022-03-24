package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@RequestMapping("/api/book")
@RestController
public class BookController {


     @Autowired
    private BookRepository bookRepository;


    @GetMapping("/book")
    public List<Book> getAllBookData(){return bookRepository.findAll();}

    //build create book Rest API
    @PostMapping("/book")
    public Book createBookEntry(@RequestBody Book book){ return bookRepository.save(book);}

    //build get book data by id Rest API
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book Does Not Exist With ID : "+id));
        return ResponseEntity.ok(book);
    }

    //build update Book Data REST API
    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateBookData(@PathVariable long id,@RequestBody Book bookDetails){
        Book updateBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book Does Not Exist With ID : "+id));

        updateBook.setAuthor(bookDetails.getAuthor());
        updateBook.setBookName(bookDetails.getBookName());
        updateBook.setDate(bookDetails.getDate());

        bookRepository.save(updateBook);

        return ResponseEntity.ok(updateBook);
    }

    //build Delete book REST API
    @DeleteMapping("/book/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book Does Not Exist With ID : "+id));

        bookRepository.delete(book);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
