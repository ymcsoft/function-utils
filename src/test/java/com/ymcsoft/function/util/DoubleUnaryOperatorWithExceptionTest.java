package com.ymcsoft.function.util;

import org.junit.Test;

import java.util.function.DoubleUnaryOperator;

import static org.junit.Assert.*;

public class DoubleUnaryOperatorWithExceptionTest {

    @Test(expected = Exception.class)
    public void handleOperatorWithException() throws Exception {
        DoubleUnaryOperator operator = DoubleUnaryOperatorWithException.handleOperatorWithException(this::exceptionMethod);
        operator.applyAsDouble(3.1415926);
    }

    @Test
    public void handleOperatorWithNoException() throws Exception {
        DoubleUnaryOperator operator = DoubleUnaryOperatorWithException.handleOperatorWithException(this::noExceptionMethod);
        assertEquals(3.1415926, operator.applyAsDouble(3.1415926), 0.0000001);
    }

    private double exceptionMethod(double d) throws Exception {
        throw new Exception("Test Exception");
    }

    private double noExceptionMethod(double d) throws Exception {
        return d;
    }
}