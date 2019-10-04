package com.ymcsoft.function.util;

import java.util.function.LongToDoubleFunction;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface LongToDoubleFunctionWithException<E extends Exception>{
    double applyAsDouble(long value) throws E;

    /**
     * handle exception in LongToDoubleFunction interface
     * usage: LongToDoubleFunctionWithException.handleFunctionWithException(func)
     * @param func function that throws checked exception
     * @param <E> exception type
     * @return LongToDoubleFunction
     * @throws E exception
     */
    static <E extends Exception> LongToDoubleFunction handleFunctionWithException(LongToDoubleFunctionWithException<E> func) throws E {
        return value -> {
            try {
                return func.applyAsDouble(value);
            } catch (Exception e) {
                handleCheckedExceptions(e);
            }
            return 0;
        };
    }
}
