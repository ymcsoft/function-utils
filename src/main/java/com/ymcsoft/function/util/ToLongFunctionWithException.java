package com.ymcsoft.function.util;

import java.util.function.ToLongFunction;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface ToLongFunctionWithException<T, E extends Exception>{
    long applyAsLong(T value) throws E;

    /**
     * handle exception in ToLongFunction&lt;T&gt; interface
     * usage: ToLongFunctionWithException.handleFunctionWithException(function)
     * @param func function that throws checked exception
     * @param <T> input type
     * @param <E> exception type
     * @return ToLongaFunction&lt;T&gt;
     * @throws E exception
     */
    static <T, E extends Exception> ToLongFunction<T> handleFunctionWithException(ToLongFunctionWithException<T, E> func) throws E {
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
