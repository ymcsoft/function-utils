package com.ymcsoft.function.util;

import java.util.function.DoubleToIntFunction;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface DoubleToIntFunctionWithException<E extends Exception>{
    int applyAsInt(double value) throws E;

    /**
     * handle exception in DoubleToIntFunction interface
     * usage: DoubleToIntFunctionWithException.handleFunctionWithException(func)
     * @param func function that throws checked exception
     * @param <E> exception type
     * @return DoubleToIntFunction
     * @throws E exception
     */
    static <E extends Exception> DoubleToIntFunction handleFunctionWithException(DoubleToIntFunctionWithException<E> func) throws E {
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
