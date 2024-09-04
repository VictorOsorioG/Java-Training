package com.globant.training.java.bookstore.repository;

import com.globant.training.java.bookstore.entity.Book;
import com.globant.training.java.bookstore.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByStatus(Status status);
}
