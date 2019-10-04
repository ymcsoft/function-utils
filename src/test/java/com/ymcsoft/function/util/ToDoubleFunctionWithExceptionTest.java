package com.ymcsoft.function.util;

import org.junit.Test;

import java.util.function.ToDoubleFunction;

import static org.junit.Assert.*;

public class ToDoubleFunctionWithExceptionTest {

    @Test(expected = Exception.class)
    public void handleFunctionWithException() throws Exception {
        ToDoubleFunction function = ToDoubleFunctionWithException.handleFunctionWithException(this::exceptionMethod);
        function.applyAsDouble("1");
    }

    @Test
    public void handleFunctionWithNoException() throws Exception {
        ToDoubleFunction function = ToDoubleFunctionWithException.handleFunctionWithException(this::noExceptionMethod);
        assertEquals(3.2, function.applyAsDouble("3.2"), 0.01);
    }

    private double exceptionMethod(String s) throws Exception {
        throw new Exception("Test Exception");
    }

    private double noExceptionMethod(String s) throws Exception {
        return Double.valueOf(s);
    }
}