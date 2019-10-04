package com.ymcsoft.function.util;

import java.util.function.LongUnaryOperator;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface LongUnaryOperatorWithException<E extends Exception>{
    long applyAsLong(long operand) throws E;

    /**
     * handle exception in LongUnaryOperator interface
     * usage: LongUnaryOperatorWithException.handleOperatorWithException(op)
     * @param op operator that throws checked exception
     * @param <E> exception type
     * @return LongUnaryOperator
     * @throws E exception
     */
    static <E extends Exception> LongUnaryOperator handleOperatorWithException(LongUnaryOperatorWithException<E> op) throws E {
        return value -> {
            try {
                return op.applyAsLong(value);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return 0;
        };
    }
}
