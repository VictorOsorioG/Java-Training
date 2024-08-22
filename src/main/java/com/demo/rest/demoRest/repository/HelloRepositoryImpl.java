package com.demo.rest.demoRest.repository;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryImpl implements HelloRepository{

    private final String HELLO = "Hello";

    @Override
    public String selectHello() {
        System.out.println("Repository --> recibe la solicitud");
        System.out.println("Repository --> devuelve el recurso solicitado");
        return HELLO;
    }
}
