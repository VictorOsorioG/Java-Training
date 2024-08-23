package com.globant.training.java.topic4.controller.injection;

import com.globant.training.java.topic4.service.injection.HelloService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {

    private final HelloService helloService;

    public ConstructorInjectedController(@Qualifier("constructorHelloServiceImpl") HelloService helloService) {
        this.helloService = helloService;
    }

    public String getHello() {
        return helloService.sayHello();
    }
}
