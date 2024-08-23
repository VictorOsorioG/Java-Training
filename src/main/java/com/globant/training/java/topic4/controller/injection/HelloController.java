package com.globant.training.java.topic4.controller.injection;

import com.globant.training.java.topic4.service.injection.HelloService;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello() {
        return helloService.sayHello();
    }
}
