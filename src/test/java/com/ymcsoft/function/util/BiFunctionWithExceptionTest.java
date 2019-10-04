package com.ymcsoft.function.util;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

import static org.junit.Assert.*;

public class BiFunctionWithExceptionTest {

    @Test(expected = Exception.class)
    public void handleBiFunctionWithException() throws Exception{
        BiFunction<String,String,String> biFunction = BiFunctionWithException.handleBiFunctionWithException(this::exceptionConcat);
        biFunction.apply("string one ", "string two");
    }

    @Test
    public void handleBiFunctionWithNoException() throws Exception {
        BiFunction<String, String, String> biFunction = BiFunctionWithException.handleBiFunctionWithException(this::concat);
        assertEquals("string one string two", biFunction.apply("string one ", "string two"));
    }

    private String exceptionConcat(String s1, String s2) throws Exception {
        throw new Exception("Test Exception");
    }

    private String concat (String s1, String s2) throws Exception {
        return s1+s2;
    }
}