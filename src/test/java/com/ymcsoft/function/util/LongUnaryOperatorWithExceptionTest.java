package com.ymcsoft.function.util;

import org.junit.Test;

import java.util.function.LongUnaryOperator;

import static org.junit.Assert.*;

public class LongUnaryOperatorWithExceptionTest {

    @Test(expected = Exception.class)
    public void handleOperatorWithException() throws Exception{
        LongUnaryOperator operator = LongUnaryOperatorWithException.handleOperatorWithException(this::exceptionMethod);
        operator.applyAsLong(1L);
    }

    @Test
    public void handleOperatorWithNoException() throws Exception{
        LongUnaryOperator operator = LongUnaryOperatorWithException.handleOperatorWithException(this::noExceptionMethod);
        assertEquals(1L, operator.applyAsLong(1L));
    }

    private long exceptionMethod(long l) throws Exception {
        throw new Exception("Test Exception");
    }

    private long noExceptionMethod(long l) throws Exception {
        return l;
    }
}