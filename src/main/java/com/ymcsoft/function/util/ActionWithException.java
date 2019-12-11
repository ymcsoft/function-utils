package com.ymcsoft.function.util;

import static com.ymcsoft.function.util.ExceptionUtil.handleCheckedExceptions;

@FunctionalInterface
public interface ActionWithException<E extends Exception>{
    void execute() throws E;

    /**
     * Handle exception in generic Action interface
     * Usage: ActionWithException.handleActionWithException(action)
     * @param action that throws checked exception
     * @param <E> exception type
     * @throws E exception
     */
    static <E extends Exception> Action handleActionWithException(ActionWithException<E> action) throws E {
        return () -> {
            try {
                action.execute();
            } catch (Exception ex) {
                handleCheckedExceptions(ex);
            }
        };
    }
}
