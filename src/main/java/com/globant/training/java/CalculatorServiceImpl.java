package com.globant.training.java;

public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public double add(double input1, double input2) {
        System.out.println("Soy real");
        return input1 + input2;
    }

    @Override
    public double subtract(double input1, double input2) {
        System.out.println("Soy real");
        return input1 - input2;
    }

    @Override
    public double multiply(double input1, double input2) {
        System.out.println("Soy real");
        return input1 * input2;
    }

    @Override
    public double divide(double input1, double input2) {
        System.out.println("Soy real");
        return input1 / input2;
    }
}
