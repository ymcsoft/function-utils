package com.ymcsoft.function.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionWithExceptionTest {
    private int count;

    @Before
    public void setUp() {
        count = 0;//reset
    }

    @Test(expected = Exception.class)
    public void testActionWithException() throws Exception {
        Action action = ActionWithException.handleActionWithException(this::exceptionMethod);
        action.execute();
    }

    @Test
    public void testActionWithNoException() throws Exception {
        Action action = ActionWithException.handleActionWithException(this::noExceptionMethod);
        action.execute();
        assertEquals(1, count);
    }

    private <T> void exceptionMethod() throws Exception {
        throw new Exception("Test Exception");
    }

    private void noExceptionMethod() throws Exception {
        count++;
    }

}