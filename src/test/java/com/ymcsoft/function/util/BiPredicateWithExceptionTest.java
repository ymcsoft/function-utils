package com.ymcsoft.function.util;

import org.junit.Test;

import java.util.function.BiPredicate;

import static org.junit.Assert.*;

public class BiPredicateWithExceptionTest {

    @Test(expected = Exception.class)
    public void handleBiPredicateWithException() throws Exception{
        BiPredicate biPredicate = BiPredicateWithException.handleBiPredicateWithException((t, u) -> exceptionMethod(t,u));
        biPredicate.test("string one", 1);
    }

    @Test
    public void handleBiPredicateWithNoException() throws Exception {
        BiPredicate biPredicate = BiPredicateWithException.handleBiPredicateWithException((t, u) -> noExceptionMethod(t,u));
        assertTrue(biPredicate.test("string two", "string one"));
    }

    private <T,U> boolean exceptionMethod(T t, U u) throws Exception {
        throw new Exception("Test Exception");
    }

    private <T, U> boolean noExceptionMethod(T t, U u) throws Exception {
        return t != null && u != null;
    }
}