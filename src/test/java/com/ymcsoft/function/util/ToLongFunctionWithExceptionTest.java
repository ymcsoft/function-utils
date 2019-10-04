package com.ymcsoft.function.util;

import org.junit.Test;

import java.util.function.ToLongFunction;

import static org.junit.Assert.*;

public class ToLongFunctionWithExceptionTest {

    @Test(expected = Exception.class)
    public void handleFunctionWithException() throws Exception {
        ToLongFunction function = ToLongFunctionWithException.handleFunctionWithException(this::exceptionMethod);
        function.applyAsLong("1");
    }

    @Test
    public void handleFunctionWithNoException() throws Exception {
        ToLongFunction function = ToLongFunctionWithException.handleFunctionWithException(this::noExceptionMethod);
        assertEquals(3, function.applyAsLong("3"));
    }

    private long exceptionMethod(String s) throws Exception {
        throw new Exception("Test Exception");
    }

    private long noExceptionMethod(String s) throws Exception {
        return Long.valueOf(s);
    }
}