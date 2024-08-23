package com.globant.training.java.topic4.service.injection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

public class PrimaryHelloServiceImpl implements HelloService{

    @Override
    public String sayHello() {
        return "Hello - Primary";
    }
}
