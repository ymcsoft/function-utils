package com.ymcsoft.function.util;

import org.junit.Test;

import java.util.function.DoubleBinaryOperator;

import static org.junit.Assert.*;

public class DoubleBinaryOperatorWithExceptionTest {

    @Test(expected = Exception.class)
    public void handleDoubleBinaryOperatorWithException() throws Exception {
        DoubleBinaryOperator operator = DoubleBinaryOperatorWithException.handleDoubleBinaryOperatorWithException((d1, d2) -> exceptionOperator(d1,d2));
        operator.applyAsDouble(1.01,2.02);
    }

    @Test
    public void handleDoubleBinaryOperatorWithNoException() throws Exception {
        DoubleBinaryOperator operator = DoubleBinaryOperatorWithException.handleDoubleBinaryOperatorWithException((d1, d2) -> noExceptionOperator(d1,d2));
        assertEquals(3.03,operator.applyAsDouble(1.01,2.02), 0.000001);
    }

    private double exceptionOperator(double d1, double d2) throws Exception {
        throw new Exception("Test Exception");
    }

    private double noExceptionOperator (double d1, double d2) throws Exception {
        return d1+d2;
    }
}