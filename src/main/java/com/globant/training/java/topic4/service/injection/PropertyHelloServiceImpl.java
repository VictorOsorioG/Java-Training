package com.globant.training.java.topic4.service.injection;

import org.springframework.stereotype.Service;

public class PropertyHelloServiceImpl implements HelloService {

    @Override
    public String sayHello() {
        return "Hello - Property";
    }
}
