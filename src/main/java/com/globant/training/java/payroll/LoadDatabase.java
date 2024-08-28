package com.globant.training.java.payroll;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            log.info("Preloading " + employeeRepository.save(Employee.builder().name("Bilbo Baggins").role("burglar").build()));
            log.info("Preloading " + employeeRepository.save(Employee.builder().name("Frodo Baggins").role("thief").build()));

            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

            orderRepository.save(Order.builder().description("MacBook Pro").status(Status.COMPLETED).build());
            orderRepository.save(Order.builder().description("Iphone").status(Status.IN_PROGRESS).build());

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });
        };
    }
}
