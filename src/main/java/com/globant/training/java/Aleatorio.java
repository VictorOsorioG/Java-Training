package com.globant.training.java;

import com.globant.training.java.interfaces.Proveedor;

import java.util.Random;

public class Aleatorio implements Proveedor {

    Random random = new Random();

    @Override
    public Integer obtener() {
        return random.nextInt(1000);
    }
}
