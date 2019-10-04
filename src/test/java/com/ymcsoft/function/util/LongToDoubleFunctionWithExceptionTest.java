package com.ymcsoft.function.util;

import static junit.framework.TestCase.assertEquals;
import org.junit.Test;

import java.util.function.LongToDoubleFunction;



public class LongToDoubleFunctionWithExceptionTest {

    @Test(expected = Exception.class)
    public void handleFunctionWithException() throws Exception {
        LongToDoubleFunction function = LongToDoubleFunctionWithException.handleFunctionWithException(this::exceptionMethod);
        function.applyAsDouble(1L);
    }

    @Test
    public void handleFunctionWithNoException() throws Exception {
        LongToDoubleFunction function = LongToDoubleFunctionWithException.handleFunctionWithException(this::noExceptionMethod);
        assertEquals(10.0, function.applyAsDouble(10L), 0.1);
    }

    private double exceptionMethod(long l) throws Exception {
        throw new Exception("Test Exception");
    }

    private double noExceptionMethod(long l) throws Exception {
        return l;
    }
}