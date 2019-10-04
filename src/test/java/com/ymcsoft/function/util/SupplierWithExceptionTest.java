package com.ymcsoft.function.util;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SupplierWithExceptionTest {

    @Test(expected = Exception.class)
    public void handleSupplierWithException() throws Exception{
        SupplierWithException.handleSupplierWithException(() -> exceptionMethod(String.class)).get();
    }

    @Test
    public void handleSupplierWithNoException() throws Exception{
        String expected = "this is a test";
        assertEquals(expected, SupplierWithException.handleSupplierWithException(() -> noExceptionMethod(expected)).get());
    }


    @Test(expected = Exception.class)
    public void handleBooleanSupplierWithException() throws Exception{
        BooleanSupplierWithException.handleSupplierWithException(() -> exceptionMethod(Boolean.class)).getAsBoolean();
    }

    @Test
    public void handleBooleanSupplierWithNoException() throws Exception{
        boolean expected = true;
        assertEquals(expected, BooleanSupplierWithException.handleSupplierWithException(() -> noExceptionMethod(expected)).getAsBoolean());
    }

    @Test(expected = Exception.class)
    public void handleIntSupplierWithException() throws Exception{
        IntSupplierWithException.handleSupplierWithException(() -> exceptionMethod(Integer.class)).getAsInt();
    }

    @Test
    public void handleIntSupplierWithNoException() throws Exception{
        int expected = -1;
        assertEquals(expected, IntSupplierWithException.handleSupplierWithException(() -> noExceptionMethod(expected)).getAsInt());
    }

    @Test(expected = Exception.class)
    public void handleLongSupplierWithException() throws Exception{
        LongSupplierWithException.handleSupplierWithException(() -> exceptionMethod(Long.class)).getAsLong();
    }

    @Test
    public void handleLongSupplierWithNoException() throws Exception{
        long expected = -10L;
        assertEquals(expected, LongSupplierWithException.handleSupplierWithException(() -> noExceptionMethod(expected)).getAsLong());
    }

    @Test(expected = Exception.class)
    public void handleDoubleSupplierWithException() throws Exception{
        DoubleSupplierWithException.handleSupplierWithException(() -> exceptionMethod(Double.class)).getAsDouble();
    }

    @Test
    public void handleDoubleSupplierWithNoException() throws Exception{
        double expected = -3.1415;
        assertEquals(expected, DoubleSupplierWithException.handleSupplierWithException(() -> noExceptionMethod(expected)).getAsDouble());
    }

    private <T> T exceptionMethod(Class<T> tClass) throws Exception {
        throw new Exception("Test Exception");
    }

    private <T> T noExceptionMethod(T obj) throws Exception {
        return obj;
    }
}
