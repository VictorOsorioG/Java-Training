package com.demo.rest.demoRest.controller;

import com.demo.rest.demoRest.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    public String hello() {
        System.out.println("Controller --> recibe la solicitud de un recurso por parte del cliente");
        System.out.println("Controller --> pide al servicio el recurso");
        String hello = helloService.sayHello();
        System.out.println("Controller --> devuelve el recurso al cliente");
        return hello;
    }
}
