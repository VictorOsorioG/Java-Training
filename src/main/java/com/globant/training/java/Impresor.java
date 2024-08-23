package com.globant.training.java;

import com.globant.training.java.interfaces.Consumidor;

public class Impresor implements Consumidor {
    @Override
    public void aceptar(Integer valor) {
        System.out.println(valor);
    }
}
