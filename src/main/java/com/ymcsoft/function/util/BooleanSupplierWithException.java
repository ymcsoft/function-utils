package com.ymcsoft.function.util;

import java.util.function.BooleanSupplier;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface BooleanSupplierWithException<E extends Exception> {
    boolean getAsBoolean() throws E;

    /**
     * handle exception in BooleanSupplier interface
     * usage: BooleanSupplierWithException.handleSupplierWithException(supplier)
     * @param supplier with exception
     * @param <E> exception type
     * @return BooleanSupplier interface
     * @throws E exception
     */
    static <E extends Exception> BooleanSupplier handleSupplierWithException(BooleanSupplierWithException<E> supplier) throws E {
        return () -> {
            boolean result = false;
            try {
                result = supplier.getAsBoolean();
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return result;
        };
    }
}
