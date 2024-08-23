package com.globant.training.java.topic4.service.injection;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


public class CatPetService implements PetService {
    @Override
    public String getPetType() {
        return "Cats Are the Best!";
    }
}