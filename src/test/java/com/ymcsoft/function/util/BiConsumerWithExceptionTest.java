package com.ymcsoft.function.util;

import org.junit.Before;
import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;

import static org.junit.Assert.*;

public class BiConsumerWithExceptionTest {
    private int count;

    @Before
    public void setUp() throws Exception {
        count = 0;
    }

    @Test(expected = Exception.class)
    public void handleBiConsumerWithException() throws Exception {
        BiConsumer biConsumer = BiConsumerWithException.handleBiConsumerWithException(this::exceptionMethod);
        biConsumer.accept("string one", "string two");
    }

    @Test
    public void handleBiConsumerWithNoException() throws Exception {
        BiConsumer biConsumer = BiConsumerWithException.handleBiConsumerWithException(this::noExceptionMethod);
        biConsumer.accept("string one", "string two");
        assertTrue(count == 1);
    }

    @Test(expected = Exception.class)
    public void handleObjIntConsumerWithException() throws Exception{
        ObjIntConsumer objIntConsumer = BiConsumerWithException.handleObjIntConsumerWithException(this::exceptionIntMethod);
        objIntConsumer.accept("string one", 1);
    }

    @Test
    public void handleObjIntConsumerWithNoException() throws Exception{
        ObjIntConsumer objIntConsumer = BiConsumerWithException.handleObjIntConsumerWithException(this::noExceptionIntMethod);
        objIntConsumer.accept("string one", 1);
        assertTrue(count == 1);
    }

    @Test(expected = Exception.class)
    public void handleObjDoubleConsumerWithException() throws Exception{
        ObjDoubleConsumer objDoubleConsumer = BiConsumerWithException.handleObjDoubleConsumerWithException(this::exceptionDoubleMethod);
        objDoubleConsumer.accept("string one", 3.1415926);
    }

    @Test
    public void handleObjDoubleConsumerWithNoException() throws Exception{
        ObjDoubleConsumer objDoubleConsumer = BiConsumerWithException.handleObjDoubleConsumerWithException(this::noExceptionDoubleMethod);
        objDoubleConsumer.accept("string one", 3.1415926);
        assertTrue(count == 1);
    }

    @Test(expected = Exception.class)
    public void handleObjLongConsumerWithException() throws Exception{
        ObjLongConsumer objLongConsumer = BiConsumerWithException.handleObjLongConsumerWithException(this::exceptionLongMethod);
        objLongConsumer.accept("string one", Long.MAX_VALUE);
    }

    @Test
    public void handleObjLongConsumerWithNoException() throws Exception{
        ObjLongConsumer objLongConsumer = BiConsumerWithException.handleObjLongConsumerWithException(this::noExceptionLongMethod);
        objLongConsumer.accept("string one", Long.MAX_VALUE);
        assertTrue(count == 1);
    }

    private <T,U> void exceptionMethod(T o, U u) throws Exception {
        throw new Exception("Test Exception");
    }

    private <T,U> void noExceptionMethod(T o, U u) throws Exception {
        count++;
    }

    private <T> void exceptionIntMethod(T obj, int i) throws Exception {
        throw new Exception("Test Exception");
    }

    private <T> void noExceptionIntMethod(T obj, int i) throws Exception {
        count++;
    }

    private <T> void exceptionDoubleMethod(T obj, double d) throws Exception {
        throw new Exception("Test Exception");
    }

    private <T> void noExceptionDoubleMethod(T obj, double d) throws Exception {
        count++;
    }

    private <T> void exceptionLongMethod(T obj, long i) throws Exception {
        throw new Exception("Test Exception");
    }

    private <T> void noExceptionLongMethod(T obj, long i) throws Exception {
        count++;
    }
}
