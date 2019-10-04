package com.ymcsoft.function.util;

import org.junit.Test;

import java.util.function.ToLongBiFunction;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class ToLongBiFunctionWithExceptionTest {
    @Test(expected = Exception.class)
    public void handleBiFunctionWithException() throws Exception{
        ToLongBiFunction<String,String> biFunction = ToLongBiFunctionWithException.handleBiFunctionWithException(this::exceptionMethod);
        biFunction.applyAsLong("1", "2");
    }

    @Test
    public void handleBiFunctionWithNoException() throws Exception{
        ToLongBiFunction<String,String> biFunction = ToLongBiFunctionWithException.handleBiFunctionWithException(this::noExceptionMethod);
        assertEquals(3, biFunction.applyAsLong("1", "2"));
    }

    private long exceptionMethod(String s1, String s2) throws Exception {
        throw new Exception("Test Exception");
    }

    private long noExceptionMethod(String s1, String s2) throws Exception {
        return Long.valueOf(s1)+Long.valueOf(s2);
    }
}