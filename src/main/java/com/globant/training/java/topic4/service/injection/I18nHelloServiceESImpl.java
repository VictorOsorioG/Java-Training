package com.globant.training.java.topic4.service.injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

public class I18nHelloServiceESImpl implements HelloService{

    @Value("${topic4.hello.es}")
    private String hello;

    @Override
    public String sayHello() {
        return hello;
    }
}
