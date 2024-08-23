package com.globant.training.java.topic4.controller;

import com.globant.training.java.topic4.controller.injection.ConstructorInjectedController;
import com.globant.training.java.topic4.service.injection.ConstructorHelloServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorInjectedControllerTest {

    ConstructorInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new ConstructorInjectedController(new ConstructorHelloServiceImpl());
    }

    @Test
    void getHello() {
        System.out.println(controller.getHello());
    }
}