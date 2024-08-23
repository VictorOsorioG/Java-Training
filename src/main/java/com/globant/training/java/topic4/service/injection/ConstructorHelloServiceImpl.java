package com.globant.training.java.topic4.service.injection;

import org.springframework.stereotype.Service;

public class ConstructorHelloServiceImpl implements HelloService{

    @Override
    public String sayHello() {
        return "Hello - Constructor";
    }
}
