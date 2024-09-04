package com.globant.training.java.bookstore.repository;

import com.globant.training.java.bookstore.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
