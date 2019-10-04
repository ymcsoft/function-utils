package com.ymcsoft.function.util;

import java.util.function.ToIntBiFunction;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface ToIntBiFunctionWithException<T, U, E extends Exception> {
    int applyAsInt(T t, U u) throws E;

    /**
     * handle exception in ToIntBiFunction&lt;T,U&gt; interface
     * usage: ToIntBiFunctionWithException.handleBiFunctionWithException(function)
     * @param func function that throws checked exception
     * @param <T> input type
     * @param <U> input type
     * @param <E> exception type
     * @return ToIntBiFunction&lt;T,U&gt;
     * @throws E exception
     */
    static <T, U, E extends Exception> ToIntBiFunction<T,U> handleBiFunctionWithException(ToIntBiFunctionWithException<T, U, E> func) throws E {
        return (T t, U u) -> {
            try {
                return func.applyAsInt(t,u);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return 0;
        };
    }
}
