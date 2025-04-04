package com.chuwa.calculator.strategy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component("MULTIPLY")
public class MultiplyOperation implements OperationStrategy {
    @Override
    public BigDecimal apply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }
}
