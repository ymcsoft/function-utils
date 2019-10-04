package com.ymcsoft.function.util;

import java.util.function.DoubleBinaryOperator;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface DoubleBinaryOperatorWithException<E extends Exception>{
    double applyAsDouble(double left, double right) throws E;

    /**
     * handle exception in generic DoubleBinaryOperator interface
     * usage: DoubleBinaryOperatorWithException.handleDoubleBinaryOperatorWithException(op)
     * @param op operator that throws checked exception
     * @param <E> exception type
     * @return DoubleBinaryOperator
     * @throws E exception
     */
    static <E extends Exception> DoubleBinaryOperator handleDoubleBinaryOperatorWithException(DoubleBinaryOperatorWithException<E> op) throws E {
        return (t, u) -> {
            try {
                return op.applyAsDouble(t,u);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return 0;
        };
    }
}
