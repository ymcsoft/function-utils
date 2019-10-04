package com.ymcsoft.function.util;

import org.junit.Test;

import java.util.function.IntToLongFunction;

import static org.junit.Assert.*;

public class IntToLongFunctionWithExceptionTest {
    @Test(expected = Exception.class)
    public void handleFunctionWithException() throws Exception {
        IntToLongFunction intToDoubleFunction = IntToLongFunctionWithException.handleFunctionWithException(this::exceptionMethod);
        intToDoubleFunction.applyAsLong(1);
    }

    @Test
    public void handleFunctionWithNoException() throws Exception {
        IntToLongFunction intToDoubleFunction = IntToLongFunctionWithException.handleFunctionWithException(this::noExceptionMethod);
        assertEquals(1L, intToDoubleFunction.applyAsLong(1));
    }

    private long exceptionMethod(int i) throws Exception {
        throw new Exception("Test Exception");
    }

    private long noExceptionMethod(int i) throws Exception {
        return i;
    }
}