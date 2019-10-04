package com.ymcsoft.function.util;

import org.junit.Test;

import java.util.function.LongToIntFunction;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class LongToIntFunctionWithExceptionTest {

    @Test(expected = Exception.class)
    public void handleFunctionWithException() throws Exception {
        LongToIntFunction longToIntFunction = LongToIntFunctionWithException.handleFunctionWithException(this::exceptionMethod);
        longToIntFunction.applyAsInt(1L);
    }

    @Test
    public void handleFunctionWithNoException() throws Exception {
        LongToIntFunction longToIntFunction = LongToIntFunctionWithException.handleFunctionWithException(this::noExceptionMethod);
        assertEquals(1, longToIntFunction.applyAsInt(1L));

    }

    private int exceptionMethod(long l) throws Exception {
        throw new Exception("Test Exception");
    }

    private int noExceptionMethod(long l) throws Exception {
        return Long.valueOf(l).intValue();
    }
}