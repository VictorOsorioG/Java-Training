package com.globant.training.java.bookstore.config;

import com.globant.training.java.bookstore.entity.Tag;
import com.globant.training.java.bookstore.repository.TagRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class LoadTags {

    @Bean
    CommandLineRunner initTags(TagRepository tagRepository) {
        return args -> {
            log.info("loading " + tagRepository.save(Tag.builder().name("Action").build()));
            log.info("loading " + tagRepository.save(Tag.builder().name("Suspense").build()));
        };
    }
}
