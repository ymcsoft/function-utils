package com.ymcsoft.function.util;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

/**
 * Utility class to allow checked exceptions in the Consumer
 * works with respective Consumer&lt;T&gt;, DoubleConsumer, IntConsumer, LongConsumer interfaces.
 * Inspired by <a href="https://www.baeldung.com/java-lambda-exceptions">Exceptions in Java 8 Lambda Expressions</a>
 * @param <T> consumer input type
 * @param <E> exception type
 */
@FunctionalInterface
public interface ConsumerWithException<T, E extends Exception>{
    void accept(T t) throws E;

    /**
     * Handle exception in generic Consumer&lt;T&gt; interface
     * Usage: ConsumerWithException.handleConsumerWithException(consumer)
     * @param consumer that throws checked exception
     * @param <T> input type
     * @param <E> exception type
     * @return Consumer&lt;T&gt;
     * @throws E exception
     */
    static <T, E extends Exception> Consumer<T> handleConsumerWithException(ConsumerWithException<T, E> consumer) throws E {
        return value -> {
            try {
                consumer.accept(value);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
        };
    }

    /**
     * Handle exception in IntConsumer interface
     * Usage: ConsumerWithException.handleIntConsumerWithException(consumer)
     * @param consumer that throws checked exception
     * @param <E> exception type
     * @return IntConsumer
     * @throws E exception
     */
    static <E extends Exception> IntConsumer handleIntConsumerWithException(ConsumerWithException<Integer, E> consumer) throws E {
        return value -> {
            try {
                consumer.accept(value);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
        };
    }

    /**
     * Handle exception in DoubleConsumer interface
     * Usage: ConsumerWithException.handleDoubleConsumerWithException(consumer)
     * @param consumer that throws checked exception
     * @param <E> exception type
     * @return DoubleConsumer
     * @throws E exception
     */
    static  <E extends Exception> DoubleConsumer handleDoubleConsumerException(ConsumerWithException<Double, E> consumer) throws E {
        return value -> {
            try {
                consumer.accept(value);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
        };
    }

    /**
     * Handle exception in LongConsumer interface
     * Usage: ConsumerWithException.handleLongConsumerWithException(consumer)
     * @param consumer that throws checked exception
     * @param <E> exception type
     * @return LongConsumer
     * @throws E exception
     */
    static  <E extends Exception>LongConsumer handleLongConsumerException(ConsumerWithException<Long, E> consumer) throws E {
        return value -> {
            try {
                consumer.accept(value);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
        };
    }


}
