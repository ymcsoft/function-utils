package com.ymcsoft.function.util;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;
/**
 * Utility class to allow checked exceptions in the Predicate
 * works with respective Predicate&lt;T&gt;, DoublePredicate, IntPredicate, LongPredicate interfaces.
 * @param <T> object type
 * @param <E> exception type
 */
@FunctionalInterface
public interface PredicateWithException<T,E extends Exception> {
    boolean test(T t) throws Exception;

    /**
     * Handles generic Predicate&lt;T&gt; with exception
     * Usage: PredicateWithException.handlePredicateWithException(predicate)
     * @param predicate predicate with exception
     * @param <T> input type
     * @param <E> exception
     * @return Predicate&lt;T&gt;
     * @throws E exception
     */
    static <T, E extends Exception> Predicate<T> handlePredicateWithException(PredicateWithException<T,E> predicate) throws E {
        return value -> {
            boolean test = false;
            try{
                test = predicate.test(value);
            } catch (Exception e) {
                handleCheckedExceptions(e);
            }
            return test;
        };
    }

    /**
     * Handles IntPredicate with exception
     * Usage: PredicateWithException.handleIntPredicateWithException(predicate)
     * @param predicate predicate with exception
     * @param <E> exception
     * @return IntPredicate
     * @throws E exception
     */
    static <E extends Exception> IntPredicate handleIntPredicateWithException(PredicateWithException<Integer,E> predicate) throws E {
        return value -> {
            boolean test = false;
            try{
                test = predicate.test(value);
            } catch (Exception e) {
                handleCheckedExceptions(e);
            }
            return test;
        };
    }

    /**
     * Handles DoublePredicate with exception
     * Usage: PredicateWithException.handleDoublePredicateWithException(predicate)
     * @param predicate predicate with exception
     * @param <E> exception
     * @return DoublePredicate
     * @throws E exception
     */
    static <E extends Exception> DoublePredicate handleDoublePredicateWithException(PredicateWithException<Double,E> predicate) throws E {
        return value -> {
            boolean test = false;
            try{
                test = predicate.test(value);
            } catch (Exception e) {
                handleCheckedExceptions(e);
            }
            return test;
        };
    }

    /**
     * Handles LongPredicate with exception
     * Usage: PredicateWithException.handleLongPredicateWithException(predicate)
     * @param predicate predicate with exception
     * @param <E> exception
     * @return LongPredicate
     * @throws E exception
     */
    static <E extends Exception> LongPredicate handleLongPredicateWithException(PredicateWithException<Long,E> predicate) throws E {
        return value -> {
            boolean test = false;
            try{
                test = predicate.test(value);
            } catch (Exception e) {
                handleCheckedExceptions(e);
            }
            return test;
        };
    }

}
