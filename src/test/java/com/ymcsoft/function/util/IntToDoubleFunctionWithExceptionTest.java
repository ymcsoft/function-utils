package com.ymcsoft.function.util;

import org.junit.Test;

import java.util.function.IntToDoubleFunction;

import static org.junit.Assert.*;

public class IntToDoubleFunctionWithExceptionTest {

    @Test(expected = Exception.class)
    public void handleFunctionWithException() throws Exception {
        IntToDoubleFunction intToDoubleFunction = IntToDoubleFunctionWithException.handleFunctionWithException(this::exceptionMethod);
        intToDoubleFunction.applyAsDouble(1);
    }

    @Test
    public void handleFunctionWithNoException() throws Exception {
        IntToDoubleFunction intToDoubleFunction = IntToDoubleFunctionWithException.handleFunctionWithException(this::noExceptionMethod);
        assertEquals(1.0, intToDoubleFunction.applyAsDouble(1), 0.001);
    }

    private double exceptionMethod(int i) throws Exception {
        throw new Exception("Test Exception");
    }

    private double noExceptionMethod(int i) throws Exception {
        return i;
    }
}