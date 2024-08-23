package com.globant.training.java.topic4.controller.injection;

import com.globant.training.java.topic4.service.injection.HelloService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class I18nController {
    private final HelloService helloService;

    public I18nController(@Qualifier("i18nService") HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello() {
        return helloService.sayHello();
    }
}
