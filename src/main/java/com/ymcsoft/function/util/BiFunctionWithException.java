package com.ymcsoft.function.util;

import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface BiFunctionWithException<T,U,R,E extends Exception> {
    R apply(T t, U u) throws E;

    /**
     * handle exception in generic BiFunction&lt;T,U,R&gt; interface
     * usage: BiFunctionWithException.handleBiFunctionWithException(function)
     * @param func function that throws checked exception
     * @param <T> input type
     * @param <U> input type
     * @param <R> output type
     * @param <E> exception type
     * @return BiFunction&lt;T,U,R&gt;
     * @throws E exception
     */
    static <T, U, R, E extends Exception> BiFunction<T,U,R> handleBiFunctionWithException(BiFunctionWithException<T, U, R, E> func) throws E {
        return (T t, U u) -> {
            R result = null;
            try {
                result =  func.apply(t,u);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return result;
        };
    }
}
