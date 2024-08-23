package com.globant.training.java.topic4.controller;

import com.globant.training.java.topic4.controller.injection.SetterInjectedController;
import com.globant.training.java.topic4.service.injection.ConstructorHelloServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectedControllerTest {

    SetterInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new SetterInjectedController();
        controller.setHelloService(new ConstructorHelloServiceImpl());
    }

    @Test
    void getHelloService() {
        System.out.println(controller.getHello());
    }
}