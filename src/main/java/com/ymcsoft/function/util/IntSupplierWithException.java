package com.ymcsoft.function.util;

import java.util.function.IntSupplier;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

public interface IntSupplierWithException<E extends Exception>{
    int getAsInt() throws E;

    /**
     * handle exception in IntSupplier interface
     * usage: IntSupplierWithException.handleSupplierWithException(supplier)
     * @param supplier with exception
     * @param <E> exception type
     * @return IntSupplier interface
     * @throws E exception
     */
    static <E extends Exception> IntSupplier handleSupplierWithException(IntSupplierWithException<E> supplier) throws E {
        return () -> {
            int result = 0;
            try {
                result = supplier.getAsInt();
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return result;
        };
    }
}
