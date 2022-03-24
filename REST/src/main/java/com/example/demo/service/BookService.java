package com.example.demo.service;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> listAll(){
        return bookRepository.findAll();
    }

    public Book get(Long id) throws BookNotFoundException {
        Optional<Book> result = bookRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new BookNotFoundException("Could Not Find Any Book with id "+ id);
    }

    public void save(Book book){
        bookRepository.save(book);
    }

    public void update(Book book, Long id) throws BookNotFoundException {
        Book updateBook = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book Does Not Exist With ID : "+id));

        updateBook.setAuthor(book.getAuthor());
        updateBook.setBookName(book.getBookName());
        updateBook.setDate(book.getDate());
        bookRepository.save(updateBook);
    }

    public void delete(Long id) throws BookNotFoundException {
        long count = bookRepository.countById(id);
        if(count == 0){
            throw new BookNotFoundException("Book Does Not Exist With ID : "+id);
        }
        bookRepository.deleteById(id);
    }

}
