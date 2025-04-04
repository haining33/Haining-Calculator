package com.chuwa.calculator.service;

import com.chuwa.calculator.model.Operation;

import java.math.BigDecimal;

public class Chain {
    private final Calculator calculator; // Reference to the parent Calculator
    private BigDecimal currentValue;

    public Chain(Calculator calculator, BigDecimal initialValue) {
        this.calculator = calculator;
        this.currentValue = initialValue;
    }

    public Chain apply(Operation op, Number operand) {
        // Uses the parent Calculator's logic
        currentValue = calculator.calculate(op, currentValue, operand);
        return this;
    }
    public BigDecimal getResult() {
        return currentValue;
    }
}