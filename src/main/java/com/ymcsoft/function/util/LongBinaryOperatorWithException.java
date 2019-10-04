package com.ymcsoft.function.util;

import java.util.function.LongBinaryOperator;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface LongBinaryOperatorWithException<E extends Exception> {
    long applyAsLong(long left, long right) throws E;

    /**
     * handle exception in LongBinaryOperator interface
     * usage: LongBinaryOperatorWithException.handleLongBinaryOperatorWithException(op)
     * @param op operator that throws checked exception
     * @param <E> exception type
     * @return LongBinaryOperator
     * @throws E exception
     */
    static <E extends Exception> LongBinaryOperator handleLongBinaryOperatorWithException(LongBinaryOperatorWithException<E> op) throws E {
        return (t, u) -> {
            try {
                return op.applyAsLong(t,u);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return 0L;
        };
    }
}
