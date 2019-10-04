package com.ymcsoft.function.util;

import org.junit.Test;

import java.util.function.ToIntFunction;

import static org.junit.Assert.*;

public class ToIntFunctionWithExceptionTest {

    @Test(expected = Exception.class)
    public void handleFunctionWithException() throws Exception {
        ToIntFunction function = ToIntFunctionWithException.handleFunctionWithException(this::exceptionMethod);
        function.applyAsInt("1");
    }

    @Test
    public void handleFunctionWithNoException() throws Exception {
        ToIntFunction function = ToIntFunctionWithException.handleFunctionWithException(this::noExceptionMethod);
        assertEquals(3, function.applyAsInt("3"));
    }

    private int exceptionMethod(String s) throws Exception {
        throw new Exception("Test Exception");
    }

    private int noExceptionMethod(String s) throws Exception {
        return Integer.valueOf(s);
    }
}