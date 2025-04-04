package com.chuwa.calculator;

import com.chuwa.calculator.model.Operation;
import com.chuwa.calculator.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorTests {
    @Autowired
    private Calculator calculator;

    @Test
    void testAdd() {
        BigDecimal result = calculator.calculate(Operation.ADD, 2, 3);
        assertEquals(new BigDecimal("5"), result);
    }

    @Test
    void testSubtract() {
        BigDecimal result = calculator.calculate(Operation.SUBTRACT, 4, 3);
        assertEquals(new BigDecimal(1), result);
    }

    @Test
    void testMultiply() {
        BigDecimal result = calculator.calculate(Operation.MULTIPLY, 3, 4);
        assertEquals(new BigDecimal(12), result);
    }

    @Test
    void testDivide() {
        BigDecimal result = calculator.calculate(Operation.DIVIDE, 5, 2);
        assertEquals(new BigDecimal(2.5), result.stripTrailingZeros());
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(Operation.DIVIDE, 5, 0)
        );
    }

    @Test
    void testChaining() {
        BigDecimal result = calculator.chainFrom(5)
                .apply(Operation.ADD, 3)
                .apply(Operation.MULTIPLY, 2)
                .getResult();
        assertEquals(new BigDecimal("16"), result);
    }

    @Test
    void testNullOperation() {
        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculate(null, 2, 3)
        );
    }
}
