package com.ymcsoft.function.util;

import org.junit.Test;

import java.util.function.IntUnaryOperator;

import static org.junit.Assert.*;

public class IntUnaryOperatorWithExceptionTest {
    @Test(expected = Exception.class)
    public void handleOperatorWithException() throws Exception {
        IntUnaryOperator operator = IntUnaryOperatorWithException.handleOperatorWithException(this::exceptionMethod);
        operator.applyAsInt(3);
    }

    @Test
    public void handleOperatorWithNoException() throws Exception {
        IntUnaryOperator operator = IntUnaryOperatorWithException.handleOperatorWithException(this::noExceptionMethod);
        assertEquals(3, operator.applyAsInt(3));
    }

    private int exceptionMethod(int i) throws Exception {
        throw new Exception("Test Exception");
    }

    private int noExceptionMethod(int i) throws Exception {
        return i;
    }
}