package com.globant.training.java;

import com.globant.training.java.interfaces.Consumidor;
import com.globant.training.java.interfaces.Predicado;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReactivePrograming {

    SuperFunciones superFunciones = new SuperFunciones();

    @Test
    void exercises() {
        System.out.println("--> Proveer la lista de numeros");
        List<Integer> numbers = SuperFunciones.proveer(5, new Aleatorio());
        System.out.println(numbers);

        System.out.println("--> Stream --> filtrar los numeros pares");
        System.out.println(numbers.stream()
                .filter(n -> n % 2 == 0).collect(Collectors.toList()));

        System.out.println("--> filtrar los numeros pares");
        System.out.println(SuperFunciones.filtrar(numbers, new SoloPares()));

        System.out.println("--> stream --> reducir el cuadrado de todos los numeros");
        System.out.println(numbers.stream()
                .reduce(0, (a, b) -> (a + (b*b)) ));

        System.out.println("--> reducir el cuadrado de todos los numeros");
        System.out.println(SuperFunciones.reducir(
                SuperFunciones.transformar(numbers, new Cuadrado()), 0, new Sumar()));

        System.out.println("--> transformar numeros al cuadrado");
        System.out.println(SuperFunciones.transformar(numbers, new Cuadrado()));

        System.out.println("--> consumir mostrar numeros uno a uno");
        SuperFunciones.consumir(numbers, new Impresor());

        System.out.println("--> clase anonima filtrar los numeros impares");
        System.out.println(SuperFunciones.filtrar(numbers, new Predicado<>() {
            @Override
            public boolean test(Integer valor) {
                return valor % 2 != 0;
            }
        }));

        System.out.println("--> clase anonima con lambda filtrar los numeros impares");
        System.out.println(SuperFunciones.filtrar(numbers, valor -> valor % 2 != 0));

        System.out.println("--> consumir con variable");
        Consumidor imprimir = new Consumidor() {
            @Override
            public void aceptar(Integer valor) {
                System.out.println(valor);
            }
        };
        SuperFunciones.consumir(numbers, imprimir);

    }
}
