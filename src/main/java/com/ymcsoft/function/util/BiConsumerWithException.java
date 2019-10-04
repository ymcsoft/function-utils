package com.ymcsoft.function.util;

import java.util.function.BiConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface BiConsumerWithException<T, U, E extends Exception> {
    void accept(T t, U u) throws E;

    /**
     * Handle exception in generic BiConsumer&lt;T,U&gt; interface
     * Usage: BiConsumerWithException.handleBiConsumerWithException(consumer)
     * @param consumer that throws checked exception
     * @param <T> input type
     * @param <U> input type
     * @param <E> exception type
     * @return BiConsumer&lt;T,U&gt;
     * @throws E exception
     */
    static <T,U,E extends Exception> BiConsumer<T,U> handleBiConsumerWithException(BiConsumerWithException<T,U,E> consumer) throws E {
        return (T t, U u) -> {
            try {
                consumer.accept(t,u);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
        };
    }

    /**
     * Handle exception in ObjIntConsumer&lt;T&gt; interface
     * Usage: BiConsumerWithException.handleObjIntConsumerWithException(consumer)
     * @param consumer that throws checked exception
     * @param <T> input type
     * @param <E> exception type
     * @return ObjIntConsumer&lt;T&gt;
     * @throws E exception
     */
    static <T,E extends Exception> ObjIntConsumer<T> handleObjIntConsumerWithException(BiConsumerWithException<T,Integer,E> consumer) throws E {
        return (T t, int u) -> {
            try {
                consumer.accept(t,u);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
        };
    }

    /**
     * Handle exception in ObjDoubleConsumer&lt;T&gt; interface
     * Usage: BiConsumerUtil.handleObjDoubleConsumerWithException(consumer)
     * @param consumer that throws checked exception
     * @param <T> input type
     * @param <E> exception type
     * @return ObjDoubleConsumer&lt;T&gt;
     * @throws E exception
     */
    static <T,E extends Exception> ObjDoubleConsumer<T> handleObjDoubleConsumerWithException(BiConsumerWithException<T,Double,E> consumer) throws E {
        return (T t, double u) -> {
            try {
                consumer.accept(t,u);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
        };
    }

    /**
     * Handle exception in ObjLongConsumer&lt;T&gt; interface
     * Usage: BiConsumerUtil.handleObjLongConsumerWithException(consumer)
     * @param consumer that throws checked exception
     * @param <T> input type
     * @param <E> exception type
     * @return ObjLongConsumer&lt;T&gt;
     * @throws E exception
     */
    static <T,E extends Exception> ObjLongConsumer<T> handleObjLongConsumerWithException(BiConsumerWithException<T,Long,E> consumer) throws E {
        return (T t, long u) -> {
            try {
                consumer.accept(t,u);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
        };
    }
}
