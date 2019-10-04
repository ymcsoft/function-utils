package com.ymcsoft.function.util;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static junit.framework.TestCase.assertTrue;

public class ConsumerWithExceptionTest {

    private int count;

    @Before
    public void setUp() {
        count = 0;//reset
    }

    @Test(expected = Exception.class)
    public void testHandleConsumerWithException() throws Exception{
        Arrays.stream(new Object[]{new Object()}).forEach(ConsumerWithException.handleConsumerWithException(this::exceptionMethod));
    }

    @Test
    public void testHandleConsumerWithNoException() throws Exception{
        Arrays.stream(new Object[]{new Object()}).forEach(ConsumerWithException.handleConsumerWithException(this::noExceptionMethod));
        assertTrue(count > 0);
    }

    @Test(expected = Exception.class)
    public void testHandleIntConsumerException() throws Exception {
        IntStream.range(0,9).forEach(ConsumerWithException.handleIntConsumerWithException(this::exceptionMethod));
    }

    @Test
    public void testHandleIntConsumerNoException() throws Exception {
        IntStream.range(0,9).forEach(ConsumerWithException.handleIntConsumerWithException(this::noExceptionMethod));
    }

    @Test(expected = Exception.class)
    public void testHandleDoubleConsumerException() throws Exception {
        LongStream.range(0L, 9L).asDoubleStream().forEach(ConsumerWithException.handleDoubleConsumerException(this::exceptionMethod));
    }

    @Test
    public void testHandleDoubleConsumerNoException() throws Exception {
        LongStream.range(0L, 9L).asDoubleStream().forEach(ConsumerWithException.handleDoubleConsumerException(this::noExceptionMethod));
    }

    @Test(expected = Exception.class)
    public void testHandleLongConsumerException() throws Exception {
        LongStream.range(0L, 9L).forEach(ConsumerWithException.handleLongConsumerException(this::exceptionMethod));
    }

    @Test
    public void testHandleLongConsumeNorException() throws Exception {
        LongStream.range(0L, 9L).forEach(ConsumerWithException.handleLongConsumerException(this::noExceptionMethod));
    }

    private <T> void exceptionMethod(T o) throws Exception {
        throw new Exception("Test Exception");
    }

    private <T> void noExceptionMethod(T o) throws Exception {
        count++;
    }

}