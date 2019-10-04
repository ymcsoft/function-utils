package com.ymcsoft.function.util;

import java.util.function.LongSupplier;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface LongSupplierWithException<E extends Exception>{
    long getAsLong() throws E;

    /**
     * handle exception in LongSupplier interface
     * usage: LongSupplierWithException.handleSupplierWithException(supplier)
     * @param supplier with exception
     * @param <E> exception type
     * @return LongSupplier interface
     * @throws E exception
     */
    static <E extends Exception> LongSupplier handleSupplierWithException(LongSupplierWithException<E> supplier) throws E {
        return () -> {
            long result = 0L;
            try {
                result = supplier.getAsLong();
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return result;
        };
    }
}
