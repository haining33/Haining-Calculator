package com.chuwa.calculator.strategy;

import com.chuwa.calculator.model.Operation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component("DIVIDE")
public class DivideOperation implements OperationStrategy {
    @Override
    public BigDecimal apply(BigDecimal a, BigDecimal b) {
        if (b.compareTo(BigDecimal.ZERO) == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a.divide(b, 10, RoundingMode.HALF_UP);
    }
}
