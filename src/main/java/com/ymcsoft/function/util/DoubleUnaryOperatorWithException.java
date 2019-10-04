package com.ymcsoft.function.util;

import java.util.function.DoubleUnaryOperator;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface DoubleUnaryOperatorWithException<E extends Exception>{
    double applyAsDouble(double operand) throws E;

    /**
     * handle exception in DoubleUnaryOperator interface
     * usage: DoubleUnaryOperatorWithException.handleOperatorWithException(op)
     * @param op operator that throws checked exception
     * @param <E> exception type
     * @return DoubleUnaryOperator
     * @throws E exception
     */
    static <E extends Exception> DoubleUnaryOperator handleOperatorWithException(DoubleUnaryOperatorWithException<E> op) throws E {
        return value -> {
            try {
                return op.applyAsDouble(value);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return 0;
        };
    }
}
