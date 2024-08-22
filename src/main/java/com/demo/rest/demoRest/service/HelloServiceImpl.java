package com.demo.rest.demoRest.service;

import com.demo.rest.demoRest.repository.HelloRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
public class HelloServiceImpl implements HelloService{

    private final HelloRepository helloRepository;

    public HelloServiceImpl(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @Override
    public String sayHello() {
        System.out.println("Service --> recibe la solicitud del recurso");
        System.out.println("Service --> hace su logica inicial, pueden ser validaciones");
        System.out.println("Service --> pide el recurso al repository");
        String hello = helloRepository.selectHello();
        System.out.println("Service --> hace la logica necesaria con el recurso obtenido");
        System.out.println("Service --> devuelve el recurso");
        return hello;
    }
}
