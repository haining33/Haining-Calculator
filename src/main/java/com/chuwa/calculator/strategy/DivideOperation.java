package com.chuwa.calculator.strategy;

import com.chuwa.calculator.model.Operation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("DIVIDE")
public class DivideOperation implements OperationStrategy {
    @Override
    public double apply(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}
