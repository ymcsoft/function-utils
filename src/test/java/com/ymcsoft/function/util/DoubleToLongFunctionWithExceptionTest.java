package com.ymcsoft.function.util;

import org.junit.Test;

import java.util.function.DoubleToLongFunction;

import static org.junit.Assert.*;

public class DoubleToLongFunctionWithExceptionTest {

    @Test(expected = Exception.class)
    public void handleFunctionWithException() throws Exception {
        DoubleToLongFunction doubleToLongFunction = DoubleToLongFunctionWithException.handleFunctionWithException(this::exceptionMethod);
        doubleToLongFunction.applyAsLong(3.1415926);
    }

    @Test
    public void handleFunctionWithNoException() throws Exception {
        DoubleToLongFunction doubleToLongFunction = DoubleToLongFunctionWithException.handleFunctionWithException(this::noExceptionMethod);
        assertEquals(3, doubleToLongFunction.applyAsLong(3.1415926));
    }

    private long exceptionMethod(double d) throws Exception {
        throw new Exception("Test Exception");
    }

    private long noExceptionMethod(double d) throws Exception {
        return Double.valueOf(d).longValue();
    }
}