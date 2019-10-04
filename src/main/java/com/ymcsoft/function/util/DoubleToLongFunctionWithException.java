package com.ymcsoft.function.util;

import java.util.function.DoubleToLongFunction;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface DoubleToLongFunctionWithException<E extends Exception>{
    long applyAsLong(double value) throws E;

    /**
     * handle exception in DoubleToLongFunction interface
     * usage: DoubleToLongFunctionWithException.handleFunctionWithException(func)
     * @param func function that throws checked exception
     * @param <E> exception type
     * @return DoubleToLongFunction
     * @throws E exception
     */
    static <E extends Exception> DoubleToLongFunction handleFunctionWithException(DoubleToLongFunctionWithException<E> func) throws E {
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
