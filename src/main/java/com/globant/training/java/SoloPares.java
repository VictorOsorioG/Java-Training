package com.globant.training.java;

import com.globant.training.java.interfaces.Predicado;

public class SoloPares implements Predicado {

    @Override
    public boolean test(Object valor) {
        return (int) valor % 2 == 0;
    }
}
