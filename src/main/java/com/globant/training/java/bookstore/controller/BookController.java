package com.globant.training.java.bookstore.controller;

import com.globant.training.java.bookstore.entity.Book;
import com.globant.training.java.bookstore.entity.Status;
import com.globant.training.java.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable Long bookId) {
        return bookService.getBook(bookId);
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @PutMapping
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

    @GetMapping("/status/{status}")
    public List<Book> getBooksByStatus(@PathVariable Status status) {
        return bookService.getBooksByStatus(status);
    }
}
