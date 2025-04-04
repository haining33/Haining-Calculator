package com.chuwa.calculator.service;

import com.chuwa.calculator.model.Operation;

import java.math.BigDecimal;

public interface Calculator {
    public BigDecimal calculate(Operation op, Number num1, Number num2);
    Chain chainFrom(Number initialValue);
}
