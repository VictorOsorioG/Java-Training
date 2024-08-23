package com.globant.training.java;

import com.globant.training.java.interfaces.Funcion;

public class Cuadrado implements Funcion {

    @Override
    public Integer aplicar(Integer valor) {
        return valor*valor;
    }
}
