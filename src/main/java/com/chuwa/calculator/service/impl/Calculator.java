package com.chuwa.calculator.service.impl;

import com.chuwa.calculator.model.Operation;
import com.chuwa.calculator.service.Chain;

public interface Calculator {
    public double calculate(Operation op, Number num1, Number num2);
    Chain chainFrom(Number initialValue);
}
