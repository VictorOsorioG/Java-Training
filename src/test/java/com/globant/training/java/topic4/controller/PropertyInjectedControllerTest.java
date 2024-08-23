package com.globant.training.java.topic4.controller;

import com.globant.training.java.topic4.controller.injection.PropertyInjectedController;
import com.globant.training.java.topic4.service.injection.ConstructorHelloServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectedControllerTest {

    PropertyInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new PropertyInjectedController();
        controller.helloService = new ConstructorHelloServiceImpl();
    }

    @Test
    void getHello() {
        System.out.println(controller.getHello());
    }

}