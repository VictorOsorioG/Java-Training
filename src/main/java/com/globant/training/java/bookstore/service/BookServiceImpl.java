package com.globant.training.java.bookstore.service;

import com.globant.training.java.bookstore.entity.Book;
import com.globant.training.java.bookstore.entity.Status;
import com.globant.training.java.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book getBook(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow();
    }

    @Override
    public void addBook(Book book) {
        checkIfBookExist(book.getId());
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book) {
        checkIfBookNotExist(book.getId());
        bookRepository.save(book);
    }

    @Override
    public List<Book> getBooksByStatus(Status status) {
        return bookRepository.findAllByStatus(status);
    }

    private void checkIfBookExist(Long id) {
        if (bookRepository.existsById(id)) {
            throw new IllegalArgumentException("Book already exist");
        }
    }

    private void checkIfBookNotExist(Long id) {
        if(!bookRepository.existsById(id)) {
            throw new IllegalArgumentException("Book does not exist");
        }
    }

}
