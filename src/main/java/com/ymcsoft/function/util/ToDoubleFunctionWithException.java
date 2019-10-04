package com.ymcsoft.function.util;

import java.util.function.ToDoubleFunction;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface ToDoubleFunctionWithException<T, E extends Exception> {
    double applyAsDouble(T value) throws E;

    /**
     * handle exception in ToDoubleFunction&lt;T&gt; interface
     * usage: ToDoubleFunctionWithException.handleFunctionWithException(function)
     * @param func function that throws checked exception
     * @param <T> input type
     * @param <E> exception type
     * @return ToDoubleFunction&lt;T&gt;
     * @throws E exception
     */
    static <T, E extends Exception> ToDoubleFunction<T> handleFunctionWithException(ToDoubleFunctionWithException<T, E> func) throws E {
        return value -> {
            try {
                return func.applyAsDouble(value);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return 0;
        };
    }
}
