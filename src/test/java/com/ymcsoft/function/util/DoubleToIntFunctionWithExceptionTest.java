package com.ymcsoft.function.util;

import org.junit.Test;

import java.util.function.DoubleToIntFunction;

import static org.junit.Assert.*;

public class DoubleToIntFunctionWithExceptionTest {

    @Test(expected = Exception.class)
    public void handlFunctionWithException() throws Exception{
        DoubleToIntFunction doubleToIntFunction = DoubleToIntFunctionWithException.handleFunctionWithException(this::exceptionMethod);
        doubleToIntFunction.applyAsInt(3.1415926);
    }

    @Test
    public void handlFunctionWithNoException() throws Exception{
        DoubleToIntFunction doubleToIntFunction = DoubleToIntFunctionWithException.handleFunctionWithException(this::noExceptionMethod);
        assertEquals(3, doubleToIntFunction.applyAsInt(3.1415926));
    }

    private int exceptionMethod(double d) throws Exception {
        throw new Exception("Test Exception");
    }

    private int noExceptionMethod(double d) throws Exception {
        return Double.valueOf(d).intValue();
    }
}