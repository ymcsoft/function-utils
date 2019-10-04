package com.ymcsoft.function.util;

import java.util.function.BiPredicate;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface BiPredicateWithException<T,U, E extends Exception>{
    boolean test(T t, U u) throws E;

    /**
     * Handles generic BiPredicate&lt;T,U&gt; with exception
     * Usage: BiPredicateWithException.handleBiPredicateWithException(predicate)
     * @param predicate predicate with exception
     * @param <T> input type
     * @param <U> input type
     * @param <E> exception
     * @return BiPredicate&lt;T,U&gt;
     * @throws E exception
     */
    static <T,U, E extends Exception> BiPredicate<T,U> handleBiPredicateWithException(BiPredicateWithException<T,U,E> predicate) throws E {
        return (T t, U u) -> {
            boolean test = false;
            try{
                test = predicate.test(t,u);
            } catch (Exception e) {
                handleCheckedExceptions(e);
            }
            return test;
        };
    }
}
