package com.ymcsoft.function.util;

import org.junit.Test;

import java.util.function.IntBinaryOperator;

import static org.junit.Assert.*;

public class IntBinaryOperatorWithExceptionTest {

    @Test(expected = Exception.class)
    public void handleIntBinaryOperatorWithException() throws Exception{
        IntBinaryOperator operator = IntBinaryOperatorWithException.handleIntBinaryOperatorWithException(this::exceptionOperator);
        operator.applyAsInt(1, 2);
    }

    @Test
    public void handleIntBinaryOperatorWithNoException() throws Exception{
        IntBinaryOperator operator = IntBinaryOperatorWithException.handleIntBinaryOperatorWithException(this::noExceptionOperator);
        assertEquals(3, operator.applyAsInt(1, 2));
    }

    private int exceptionOperator(int i1, int i2) throws Exception {
        throw new Exception("Test Exception");
    }

    private int noExceptionOperator(int i1, int i2) throws Exception {
        return i1 + i2;
    }
}