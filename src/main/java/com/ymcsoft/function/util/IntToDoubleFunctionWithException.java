package com.ymcsoft.function.util;

import java.util.function.IntToDoubleFunction;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface IntToDoubleFunctionWithException<E extends Exception>{
    double applyAsDouble(int value) throws E;

    /**
     * handle exception in IntToDoubleFunction interface
     * usage: IntToDoubleFunctionWithException.handleFunctionWithException(func)
     * @param func function that throws checked exception
     * @param <E> exception type
     * @return IntToDoubleFunction
     * @throws E exception
     */
    static <E extends Exception> IntToDoubleFunction handleFunctionWithException(IntToDoubleFunctionWithException<E> func) throws E {
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
