package com.ymcsoft.function.util;

import org.junit.Test;


import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.*;


public class PredicateWithExceptionTest {

    @Test(expected = Exception.class)
    public void handlePredicateWithException() throws Exception {
        Arrays.stream(new Object[]{new Object()}).allMatch(PredicateWithException.handlePredicateWithException(this::exceptionMethod));
    }

    @Test
    public void handlePredicateWithNoException() throws Exception {
        assertTrue(Arrays.stream(new Object[]{new Object()}).allMatch(PredicateWithException.handlePredicateWithException(this::noExceptionMethod)));
    }

    @Test(expected = Exception.class)
    public void handleIntPredicateWithException() throws Exception{
        IntStream.range(0,9).allMatch(PredicateWithException.handleIntPredicateWithException(this::exceptionMethod));
    }

    @Test
    public void handleIntPredicateWithNoException() throws Exception{
        assertTrue(IntStream.range(0,9).allMatch(PredicateWithException.handleIntPredicateWithException(this::noExceptionMethod)));
    }

    @Test(expected = Exception.class)
    public void handleDoublePredicateWithException() throws Exception {
        IntStream.range(0,9).asDoubleStream().allMatch(PredicateWithException.handleDoublePredicateWithException(this::exceptionMethod));
    }

    @Test
    public void handleDoublePredicateNoWithException() throws Exception {
        IntStream.range(0,9).asDoubleStream().allMatch(PredicateWithException.handleDoublePredicateWithException(this::noExceptionMethod));
    }


    @Test(expected = Exception.class)
    public void handleLongPredicateWithException() throws Exception {
        IntStream.range(0,9).asLongStream().allMatch(PredicateWithException.handleLongPredicateWithException(this::exceptionMethod));
    }

    @Test
    public void handleLongPredicateWithNoException() throws Exception {
        IntStream.range(0,9).asLongStream().allMatch(PredicateWithException.handleLongPredicateWithException(this::noExceptionMethod));
    }

    private <T> boolean exceptionMethod(T o) throws Exception {
        throw new Exception("Test Exception");
    }

    private <T> boolean noExceptionMethod(T o) throws Exception {
        return true;
    }



}
