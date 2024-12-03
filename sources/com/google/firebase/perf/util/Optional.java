package com.google.firebase.perf.util;

import java.util.NoSuchElementException;

public final class Optional<T> {
    private final T value;

    private Optional() {
        this.value = null;
    }

    public static <T> Optional<T> absent() {
        return new Optional<>();
    }

    public static <T> Optional<T> fromNullable(T t10) {
        return t10 == null ? absent() : of(t10);
    }

    public static <T> Optional<T> of(T t10) {
        return new Optional<>(t10);
    }

    public T get() {
        T t10 = this.value;
        if (t10 != null) {
            return t10;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean isAvailable() {
        return this.value != null;
    }

    private Optional(T t10) {
        if (t10 != null) {
            this.value = t10;
            return;
        }
        throw new NullPointerException("value for optional is empty.");
    }
}
