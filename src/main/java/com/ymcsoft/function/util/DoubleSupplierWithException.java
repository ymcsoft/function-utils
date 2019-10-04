package com.ymcsoft.function.util;

import java.util.function.DoubleSupplier;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface DoubleSupplierWithException<E extends Exception>{
    double getAsDouble() throws E;

    /**
     * handle exception in DoubleSupplier interface
     * usage: DoubleSupplierWithException.handleSupplierWithException(supplier)
     * @param supplier with exception
     * @param <E> exception type
     * @return DoubleSupplier interface
     * @throws E exception
     */
    static <E extends Exception> DoubleSupplier handleSupplierWithException(DoubleSupplierWithException<E> supplier) throws E {
        return () -> {
            double result = 0.0;
            try {
                result = supplier.getAsDouble();
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return result;
        };
    }
}
