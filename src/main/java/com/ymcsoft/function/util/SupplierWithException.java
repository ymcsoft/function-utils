package com.ymcsoft.function.util;

import java.util.function.Supplier;

@FunctionalInterface
public interface SupplierWithException<T, E extends Exception>{
    T get() throws E;

    /**
     * handle exception in generic Supplier&lt;T&gt; interface
     * usage: SupplierWithException.handleSupplierWithException(supplier)
     * @param supplier with exception
     * @param <T> input type
     * @param <E> exception type
     * @return Supplier&lt;T&gt; interface
     * @throws E exception
     */
    static <T, E extends Exception> Supplier<T> handleSupplierWithException(SupplierWithException<T, E> supplier) throws E {
        return () -> {
            T result = null;
            try {
                result = supplier.get();
            } catch (Exception ex) {
                ExceptionUtil.handleCheckedExceptions(ex);
            }
            return result;
        };
    }

}
