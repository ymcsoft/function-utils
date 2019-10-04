package com.ymcsoft.function.util;

import org.junit.Test;

import java.util.function.ToIntBiFunction;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class ToIntBiFunctionWithExceptionTest {

    @Test(expected = Exception.class)
    public void handleBiFunctionWithException() throws Exception{
        ToIntBiFunction<String,String> biFunction = ToIntBiFunctionWithException.handleBiFunctionWithException(this::exceptionMethod);
        biFunction.applyAsInt("1", "2");
    }

    @Test
    public void handleBiFunctionWithNoException() throws Exception{
        ToIntBiFunction<String,String> biFunction = ToIntBiFunctionWithException.handleBiFunctionWithException(this::noExceptionMethod);
        assertEquals(3, biFunction.applyAsInt("1", "2"));
    }

    private int exceptionMethod(String s1, String s2) throws Exception {
        throw new Exception("Test Exception");
    }

    private int noExceptionMethod(String s1, String s2) throws Exception {
        return Integer.valueOf(s1)+Integer.valueOf(s2);
    }
}