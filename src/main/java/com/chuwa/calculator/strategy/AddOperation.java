package com.chuwa.calculator.strategy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("ADD") // Matches the Operation enum name
public class AddOperation implements OperationStrategy {
    @Override
    public BigDecimal apply(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }
}