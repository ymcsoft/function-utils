package com.ymcsoft.function.util;

import java.util.function.LongToIntFunction;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface LongToIntFunctionWithException<E extends Exception>{
    int applyAsInt(long value) throws E;

    /**
     * handle exception in LongToIntFunction interface
     * usage: LongToIntFunctionWithException.handleFunctionWithException(func)
     * @param func function that throws checked exception
     * @param <E> exception type
     * @return LongToIntFunction
     * @throws E exception
     */
    static <E extends Exception> LongToIntFunction handleFunctionWithException(LongToIntFunctionWithException<E> func) throws E {
        return value -> {
            try {
                return func.applyAsInt(value);
            } catch (Exception e) {
                handleCheckedExceptions(e);
            }
            return 0;
        };
    }
}
