package com.coffeemeetsbagel.utils.model;

import java.io.Serializable;
import java.util.Objects;

public class Optional<T> implements Serializable {
    private final T value;

    private Optional(T t10) {
        this.value = t10;
    }

    public static <T> Optional<T> a() {
        return new Optional<>((Object) null);
    }

    public static <T> Optional<T> b(T t10) {
        return new Optional<>(t10);
    }

    public static <T> Optional<T> e(T t10) {
        if (t10 != null) {
            return new Optional<>(t10);
        }
        throw new IllegalStateException("value is absent");
    }

    public T c() {
        if (d()) {
            return this.value;
        }
        throw new IllegalStateException("value is absent");
    }

    public boolean d() {
        return this.value != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.value, ((Optional) obj).value);
    }

    public T f(T t10) {
        if (d()) {
            return this.value;
        }
        return t10;
    }

    public T g() {
        if (d()) {
            return this.value;
        }
        return null;
    }

    public int hashCode() {
        T t10 = this.value;
        if (t10 != null) {
            return t10.hashCode();
        }
        return 0;
    }
}
