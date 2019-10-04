package com.ymcsoft.function.util;

import org.junit.Test;

import java.util.function.ToDoubleBiFunction;

import static junit.framework.TestCase.assertEquals;


public class ToDoubleBiFunctionWithExceptionTest {

    @Test(expected = Exception.class)
    public void handleBiFunctionWithException() throws Exception{
        ToDoubleBiFunction<String,String> biFunction = ToDoubleBiFunctionWithException.handleBiFunctionWithException(this::exceptionMethod);
        biFunction.applyAsDouble("1", "2");
    }

    @Test
    public void handleBiFunctionWithNoException() throws Exception{
        ToDoubleBiFunction<String,String> biFunction = ToDoubleBiFunctionWithException.handleBiFunctionWithException(this::noExceptionMethod);
        assertEquals(3.0, biFunction.applyAsDouble("1.0", "2.0"), 0.1);
    }

    private double exceptionMethod(String s1, String s2) throws Exception {
        throw new Exception("Test Exception");
    }

    private double noExceptionMethod(String s1, String s2) throws Exception {
        return Double.valueOf(s1)+Double.valueOf(s2);
    }
}