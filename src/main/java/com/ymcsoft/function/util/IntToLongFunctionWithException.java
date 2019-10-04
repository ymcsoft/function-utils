package com.ymcsoft.function.util;

import java.util.function.IntToLongFunction;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface IntToLongFunctionWithException<E extends Exception> {
    long applyAsLong(int value) throws E;

    /**
     * handle exception in IntToLongFunction interface
     * usage: IntToLongFunctionWithException.handleFunctionWithException(func)
     * @param func function that throws checked exception
     * @param <E> exception type
     * @return IntToLongFunction
     * @throws E exception
     */
    static <E extends Exception> IntToLongFunction handleFunctionWithException(IntToLongFunctionWithException<E> func) throws E {
        return value -> {
            try {
                return func.applyAsLong(value);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return 0;
        };
    }
}
