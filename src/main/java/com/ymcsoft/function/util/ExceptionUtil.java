package com.ymcsoft.function.util;

final class ExceptionUtil {
    /**
     * <p> The E of handleCheckedExceptions is inferred to be RuntimeException as per
     * <a href="http://docs.oracle.com/javase/specs/jls/se8/html/jls-18.html">Chapter 18. Type Inference</a>
     * of Java 8 Language Specification
     * @param t throwable
     * @param <E> exception type
     * @throws E exception
     */
    @SuppressWarnings("unchecked")
    static <E extends Throwable> void handleCheckedExceptions(Throwable t) throws E {
        throw (E) t;
    }

    private ExceptionUtil() {}
}
