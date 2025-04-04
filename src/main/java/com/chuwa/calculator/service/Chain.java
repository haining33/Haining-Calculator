package com.chuwa.calculator.service;

import com.chuwa.calculator.model.Operation;
import com.chuwa.calculator.service.impl.Calculator;

public class Chain {
    private final Calculator calculator; // Reference to the parent Calculator
    private double currentValue;

    public Chain(Calculator calculator, double initialValue) {
        this.calculator = calculator;
        this.currentValue = initialValue;
    }

    public Chain apply(Operation op, Number operand) {
        // Uses the parent Calculator's logic
        currentValue = calculator.calculate(op, currentValue, operand);
        return this;
    }
    public double getResult() {
        return currentValue;
    }
}