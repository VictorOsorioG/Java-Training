package com.globant.training.java.topic4.service.injection.config;

import com.globant.training.java.topic4.repository.ENRepository;
import com.globant.training.java.topic4.repository.ENRepositoryImpl;
import com.globant.training.java.topic4.service.injection.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class HelloServiceConfig {

    @Bean
    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

    @Bean
    @Profile("dog")
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Bean
    @Profile("ES")
    I18nHelloServiceESImpl i18nService() {
        return new I18nHelloServiceESImpl();
    }

    @Bean
    ENRepository enRepository() {
        return new ENRepositoryImpl();
    }

    @Bean ("i18nService")
    @Profile("EN")
    I18nHelloServiceENImpl i18nENService(ENRepository enRepository) {
        return new I18nHelloServiceENImpl(enRepository);
    }

    @Primary
    @Bean
    PrimaryHelloServiceImpl primaryHelloServiceImpl() {
        return new PrimaryHelloServiceImpl();
    }

    @Bean
    ConstructorHelloServiceImpl constructorHelloServiceImpl() {
        return new ConstructorHelloServiceImpl();
    }

    @Bean
    PropertyHelloServiceImpl propertyHelloServiceImpl() {
        return new PropertyHelloServiceImpl();
    }

    @Bean
    SetterHelloServiceImpl setterHelloServiceImpl() {
        return new SetterHelloServiceImpl();
    }

}
