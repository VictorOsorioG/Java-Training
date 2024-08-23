package com.globant.training.java;

import com.globant.training.java.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class SuperFunciones {
    public static <T> List<T> filtrar(List<T> valores, Predicado<T> predicado) {
        List<T> result = new ArrayList<>();
        for (T valor: valores) {
            if (predicado.test(valor)) {
                result.add(valor);
            }
        }
        return  result;
    }

    public static List<Integer> proveer(int size, Proveedor proveedor) {
        List<Integer> resultado = new ArrayList<>();
        for (int i= 0; i<size; i++) {
            resultado.add(proveedor.obtener());
        }
        return resultado;
    }

    public static List<Integer> transformar(List<Integer> valores, Funcion funcion) {
        List<Integer> resultado = new ArrayList<>();
        for (Integer valor : valores) {
            resultado.add(funcion.aplicar(valor));
        }
        return resultado;
    }

    public static List<Integer> consumir(List<Integer> valores, Consumidor consumidor) {
        List<Integer> resultado = new ArrayList<>();
        for (Integer valor : valores) {
            consumidor.aceptar(valor);
        }
        return resultado;
    }

    public static Integer reducir(List<Integer> numeros, Integer identidad, FuncionBinaria funcionBinaria){
        int total = identidad;

        for (Integer numero: numeros) {
            total = funcionBinaria.aplicar(total, numero);
        }

        return total;
    }

    public static <T> List<T> filtrarGenerico(List<T> valores, Predicado predicado) {
        List<T> resultado = new ArrayList<>();
        for (T valor : valores) {
            if (predicado.test(valor)) {
                resultado.add(valor);
            }
        }
        return resultado;
    }
}
