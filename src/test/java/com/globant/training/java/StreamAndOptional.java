package com.globant.training.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class StreamAndOptional {

    List<String> stringList = List.of("Hola", "Carro", "Java", "Trainee", "justBefore", "Italy", "factory");

    @Test
    void streams() {
       stringList.parallelStream().forEach(this::toLowerCase);
    }

    @Test
    void optional() {
        Optional<String> empty = Optional.empty();
        Assertions.assertFalse(empty.isPresent());
    }

    private void toLowerCase(String s) {
        System.out.println(s.toLowerCase());
    }
}