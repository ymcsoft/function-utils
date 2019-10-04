package com.ymcsoft.function.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.DoubleFunction;
import java.util.function.IntFunction;
import java.util.function.LongFunction;

import static junit.framework.TestCase.assertEquals;

public class FunctionWithExceptionTest {

    @Test(expected = Exception.class)
    public void handleException() throws Exception{
        Arrays.stream(new Object[]{new Object()}).map(FunctionWithException.handleFunctionWithException(this::exceptionMethod)).findAny().get();
    }

    @Test
    public void handleWithNoException() throws Exception {
        String expected = "this is a test";
        String actual = Arrays.stream(new String[]{expected}).map(FunctionWithException.handleFunctionWithException(this::noExceptionMethod)).findAny().get();
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void testHandleIntFunctionWithException() throws Exception {
        IntFunction<Integer> func = FunctionWithException.handleIntFunctionWithException(this::exceptionMethod);
        func.apply(0);
    }

    @Test
    public void testHandleIntFunctionWithNoException() throws Exception {
        IntFunction<Integer> func = FunctionWithException.handleIntFunctionWithException(this::noExceptionMethod);
        assertEquals(10, func.apply(10).intValue());
    }

    @Test(expected = Exception.class)
    public void testHandleDoubleFunctionWithException() throws Exception {
        DoubleFunction func = FunctionWithException.handleDoubleFunctionWithException(this::exceptionMethod);
        func.apply(0.0);
    }

    @Test
    public void testHandleDoubleFunctionWithNoException() throws Exception {
        DoubleFunction func = FunctionWithException.handleDoubleFunctionWithException(this::noExceptionMethod);
        assertEquals(10.0, func.apply(10.0));
    }

    @Test(expected = Exception.class)
    public void testHandleLongFunctionWithException() throws Exception {
        LongFunction func = FunctionWithException.handleLongFunctionWithException(this::exceptionMethod);
        func.apply(0);
    }

    @Test
    public void testHandleLongFunctionWithNoException() throws Exception {
        LongFunction func = FunctionWithException.handleLongFunctionWithException(this::noExceptionMethod);
        assertEquals(10L, func.apply(10L));
    }

    private <T> T exceptionMethod(T obj) throws Exception {
        throw new Exception("Test Exception");
    }

    private <T> T noExceptionMethod(T obj) throws Exception {
        return obj;
    }
}