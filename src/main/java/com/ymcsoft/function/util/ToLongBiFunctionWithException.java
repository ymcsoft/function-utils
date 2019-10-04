package com.ymcsoft.function.util;

import java.util.function.ToLongBiFunction;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface ToLongBiFunctionWithException<T, U, E extends Exception>{
    long applyAsLong(T t, U u) throws E;

    /**
     * handle exception in ToLongBiFunction&lt;T,U&gt; interface
     * usage: ToLongBiFunctionWithException.handleBiFunctionWithException(function)
     * @param func function that throws checked exception
     * @param <T> input type
     * @param <U> input type
     * @param <E> exception type
     * @return ToLongBiFunction&lt;T,U&gt;
     * @throws E exception
     */
    static <T, U, E extends Exception> ToLongBiFunction<T,U> handleBiFunctionWithException(ToLongBiFunctionWithException<T, U, E> func) throws E {
        return (T t, U u) -> {
            try {
                return func.applyAsLong(t,u);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return 0;
        };
    }
}
