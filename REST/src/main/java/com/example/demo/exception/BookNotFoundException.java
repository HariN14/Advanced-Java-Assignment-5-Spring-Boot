package com.example.demo.exception;

public class BookNotFoundException extends Throwable {
    public BookNotFoundException(String message) {
        super(message);
    }
}
