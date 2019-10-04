package com.ymcsoft.function.util;

import java.util.function.IntBinaryOperator;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface IntBinaryOperatorWithException<E extends Exception>{
    int applyAsInt(int left, int right) throws E;

    /**
     * handle exception in IntBinaryOperator interface
     * usage: IntBinaryOperatorWithException.handleIntBinaryOperatorWithException(op)
     * @param op operator that throws checked exception
     * @param <E> exception type
     * @return IntBinaryOperator
     * @throws E exception
     */
    static <E extends Exception> IntBinaryOperator handleIntBinaryOperatorWithException(IntBinaryOperatorWithException<E> op) throws E {
        return (t, u) -> {
            try {
                return op.applyAsInt(t,u);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return 0;
        };
    }
}
