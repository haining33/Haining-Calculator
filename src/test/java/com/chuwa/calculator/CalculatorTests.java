package com.chuwa.calculator;

import com.chuwa.calculator.model.Operation;
import com.chuwa.calculator.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorTests {
    @Autowired
    private Calculator calculator;

    @Test
    void testAdd() {
        assertEquals(5, calculator.calculate(Operation.ADD, 2, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(1, calculator.calculate(Operation.SUBTRACT, 4, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(12, calculator.calculate(Operation.MULTIPLY, 3, 4));
    }

    @Test
    void testDivide() {
        assertEquals(2.5, calculator.calculate(Operation.DIVIDE, 5, 2));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(Operation.DIVIDE, 5, 0)
        );
    }

    @Test
    void testChaining() {
        double result = calculator.chainFrom(5)
                .apply(Operation.ADD, 3)
                .apply(Operation.MULTIPLY, 2)
                .getResult();
        assertEquals(16, result);
    }

    @Test
    void testNullOperation() {
        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculate(null, 2, 3)
        );
    }
}
