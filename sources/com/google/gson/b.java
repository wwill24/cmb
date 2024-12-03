package com.google.gson;

import java.lang.reflect.Field;
import java.util.Objects;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Field f21256a;

    public b(Field field) {
        Objects.requireNonNull(field);
        Field field2 = field;
        this.f21256a = field;
    }

    public String toString() {
        return this.f21256a.toString();
    }
}
