package com.globant.training.java.payroll;

public class OrderNotFoundException extends RuntimeException{
    OrderNotFoundException(Long id) {
        super("Could not found order " + id);
    }
}
