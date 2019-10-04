package com.ymcsoft.function.util;

import java.util.function.IntUnaryOperator;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface IntUnaryOperatorWithException<E extends Exception> {
    int applyAsInt(int operand) throws E;

    /**
     * handle exception in IntUnaryOperator interface
     * usage: IntUnaryOperatorWithException.handleOperatorWithException(op)
     * @param op operator that throws checked exception
     * @param <E> exception type
     * @return IntUnaryOperator
     * @throws E exception
     */
    static <E extends Exception> IntUnaryOperator handleOperatorWithException(IntUnaryOperatorWithException<E> op) throws E {
        return value -> {
            try {
                return op.applyAsInt(value);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return 0;
        };
    }
}
