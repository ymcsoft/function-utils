package com.ymcsoft.function.util;

import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongFunction;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

/**
 * Utility class to allow checked exceptions in the Function
 * works with respective Function&lt;T,R&gt;, DoubleFunction&lt;R&gt;, IntFunction&lt;R&gt;, LongFunction&lt;R&gt; interfaces.
 * @param <T> object type
 * @param <R> return type
 * @param <E> exception type
 */
@FunctionalInterface
public interface FunctionWithException<T,R, E extends Exception>{
    R apply(T t) throws E;

    /**
     * handle exception in generic Function&lt;T,R&gt; interface
     * usage: FunctionWithException.handleFunctionWithException(function)
     * @param func function that throws checked exception
     * @param <T> input type
     * @param <R> output type
     * @param <E> exception type
     * @return Function&lt;T,R&gt;
     * @throws E exception
     */
    static <T, R, E extends Exception> Function<T,R> handleFunctionWithException(FunctionWithException<T, R, E> func) throws E {
        return value -> {
            R result = null;
            try {
                result =  func.apply(value);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return result;
        };
    }

    /**
     * handle exception in IntFunction&lt;R&gt; interface
     * usage: FunctionWithException.handleIntFunctionWithException(function)
     * @param func function that throws checked exception
     * @param <R> output type
     * @param <E> exception type
     * @return IntFunction&lt;R&gt;
     * @throws E exception
     */
    static <R, E extends Exception> IntFunction<R> handleIntFunctionWithException(FunctionWithException<Integer, R, E> func) throws E {
        return value -> {
            R result = null;
            try {
                result =  func.apply(value);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return result;
        };
    }

    /**
     * handle exception in DoubleFunction&lt;R&gt; interface
     * usage: FunctionWithException.handleDoubleFunctionWithException(function)
     * @param func function that throws checked exception
     * @param <R> output type
     * @param <E> exception type
     * @return DoubleFunction&lt;R&gt;
     * @throws E exception
     */
    static <R, E extends Exception> DoubleFunction<R> handleDoubleFunctionWithException(FunctionWithException<Double, R, E> func) throws E {
        return value -> {
            R result = null;
            try {
                result =  func.apply(value);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return result;
        };
    }

    /**
     * handle exception in LongFunction&lt;R&gt; interface
     * usage: FunctionWithException.handleLongFunctionWithException(function)
     * @param func function that throws checked exception
     * @param <R> output type
     * @param <E> exception type
     * @return LongFunction&lt;R&gt;
     * @throws E exception
     */
    static <R, E extends Exception> LongFunction<R> handleLongFunctionWithException(FunctionWithException<Long, R, E> func) throws E {
        return value -> {
            R result = null;
            try {
                result =  func.apply(value);
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
            return result;
        };
    }

}
