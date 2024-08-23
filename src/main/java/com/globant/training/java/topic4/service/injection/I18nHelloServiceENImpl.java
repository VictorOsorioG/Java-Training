package com.globant.training.java.topic4.service.injection;

import com.globant.training.java.topic4.repository.ENRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

public class I18nHelloServiceENImpl implements HelloService{

    private final ENRepository enRepository;

    public I18nHelloServiceENImpl(ENRepository enRepository) {
        this.enRepository = enRepository;
    }

    @Override
    public String sayHello() {
        return enRepository.getHello();
    }
}
