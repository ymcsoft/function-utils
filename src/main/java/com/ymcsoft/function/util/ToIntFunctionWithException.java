package com.ymcsoft.function.util;

import java.util.function.ToIntFunction;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface ToIntFunctionWithException<T, E extends Exception>{
    int applyAsInt(T value) throws E;

    /**
     * handle exception in ToIntFunction&lt;T&gt; interface
     * usage: ToIntFunctionWithException.handleFunctionWithException(function)
     * @param func function that throws checked exception
     * @param <T> input type
     * @param <E> exception type
     * @return ToIntFunction&lt;T&gt;
     * @throws E exception
     */
    static <T, E extends Exception> ToIntFunction<T> handleFunctionWithException(ToIntFunctionWithException<T, E> func) throws E {
        return value -> {
            try {
                return func.applyAsInt(value);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return 0;
        };
    }
}
