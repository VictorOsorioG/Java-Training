package com.globant.training.java.topic4.service.injection;

import org.springframework.stereotype.Service;

public class SetterHelloServiceImpl implements HelloService{
    @Override
    public String sayHello() {
        return "Hello - Setter";
    }
}
