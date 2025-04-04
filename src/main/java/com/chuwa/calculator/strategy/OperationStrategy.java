package com.chuwa.calculator.strategy;

import java.math.BigDecimal;

public interface OperationStrategy {
    BigDecimal apply(BigDecimal a, BigDecimal b);
}
