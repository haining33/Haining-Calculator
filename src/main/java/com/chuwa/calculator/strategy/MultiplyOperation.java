package com.chuwa.calculator.strategy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("MULTIPLY")
public class MultiplyOperation implements OperationStrategy {
    @Override
    public double apply(double a, double b) {
        return a * b;
    }
}
