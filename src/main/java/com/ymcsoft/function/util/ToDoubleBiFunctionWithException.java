package com.ymcsoft.function.util;

import java.util.function.ToDoubleBiFunction;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface ToDoubleBiFunctionWithException<T,U,E extends Exception>{
    double applyAsDouble(T t, U u) throws E;

    /**
     * handle exception in ToDoubleBiFunction&lt;T,U&gt; interface
     * usage: ToDoubleBiFunctionWithException.handleBiFunctionWithException(function)
     * @param func function that throws checked exception
     * @param <T> input type
     * @param <U> input type
     * @param <E> exception type
     * @return ToDoubleBiFunction&lt;T,U&gt;
     * @throws E exception
     */
    static <T, U, E extends Exception> ToDoubleBiFunction<T,U> handleBiFunctionWithException(ToDoubleBiFunctionWithException<T, U, E> func) throws E {
        return (T t, U u) -> {
            try {
                return func.applyAsDouble(t,u);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return 0;
        };
    }
}
