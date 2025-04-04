package com.chuwa.calculator.service;


import com.chuwa.calculator.model.Operation;
import com.chuwa.calculator.service.impl.Calculator;
import com.chuwa.calculator.strategy.OperationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.EnumMap;
import java.util.Map;

@Service
public class CalculatorImpl implements Calculator {
    private final EnumMap<Operation, OperationStrategy> strategies;

    @Autowired
    public CalculatorImpl(Map<String, OperationStrategy> strategyMap) {
        this.strategies = new EnumMap<>(Operation.class);
        strategyMap.forEach((qualifier, strategy) -> {
            Operation op = Operation.valueOf(qualifier);
            strategies.put(op, strategy);
        });
    }
    @Override
    public double calculate(Operation op, Number num1, Number num2) {
        if (op == null || num1 == null || num2 == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        if (!strategies.containsKey(op)) {
            throw new UnsupportedOperationException("Unsupported operation: " + op);
        }
        return strategies.get(op).apply(num1.doubleValue(), num2.doubleValue());
    }
    @Override
    public Chain chainFrom(Number initialValue) {
        return new Chain(this, initialValue.doubleValue());
    }

}
