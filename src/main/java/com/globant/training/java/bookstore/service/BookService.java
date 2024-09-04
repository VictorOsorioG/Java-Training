package com.globant.training.java.bookstore.service;

import com.globant.training.java.bookstore.entity.Book;
import com.globant.training.java.bookstore.entity.Status;

import java.util.List;

public interface BookService {
    Book getBook(Long bookId);

    void addBook(Book book);

    void updateBook(Book book);

    List<Book> getBooksByStatus(Status status);
}

