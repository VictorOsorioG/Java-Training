package com.globant.training.java;

import com.globant.training.java.interfaces.FuncionBinaria;

public class Sumar implements FuncionBinaria {
    @Override
    public Integer aplicar(Integer valor1, Integer valor2) {
        return valor1 + valor2;
    }
}
