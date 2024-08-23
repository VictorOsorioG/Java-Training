package com.globant.training.java.topic4.controller.injection;

import com.globant.training.java.topic4.service.injection.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectedController {

    private HelloService helloService;

    public String getHello() {
        return helloService.sayHello();
    }

    @Qualifier("setterHelloServiceImpl")
    @Autowired
    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }
}
