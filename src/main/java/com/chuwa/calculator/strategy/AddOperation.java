package com.chuwa.calculator.strategy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("ADD") // Matches the Operation enum name
public class AddOperation implements OperationStrategy {
    @Override
    public double apply(double a, double b) {
        return a + b;
    }
}