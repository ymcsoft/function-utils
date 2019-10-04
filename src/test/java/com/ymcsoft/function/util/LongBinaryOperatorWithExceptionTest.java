package com.ymcsoft.function.util;

import org.junit.Test;

import java.util.function.LongBinaryOperator;

import static org.junit.Assert.*;

public class LongBinaryOperatorWithExceptionTest {

    @Test(expected = Exception.class)
    public void handleLongBinaryOperatorWithException() throws Exception{
        LongBinaryOperator operator = LongBinaryOperatorWithException.handleLongBinaryOperatorWithException(this::exceptionOperator);
        operator.applyAsLong(1, 2);
    }

    @Test
    public void handleLongBinaryOperatorWithNoException() throws Exception{
        LongBinaryOperator operator = LongBinaryOperatorWithException.handleLongBinaryOperatorWithException(this::noExceptionOperator);
        assertEquals(3, operator.applyAsLong(1, 2));
    }

    private long exceptionOperator(long l1, long l2) throws Exception {
        throw new Exception("Test Exception");
    }

    private long noExceptionOperator(long l1, long l2) throws Exception {
        return l1 + l2;
    }
}