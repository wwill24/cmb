package com.withpersona.sdk2.inquiry.modal;

import di.b;
import kotlin.jvm.internal.j;

public final class c {
    public static final <B, T> b<B, T> a(T t10, B b10, String str) {
        j.g(t10, "<this>");
        j.g(b10, "baseScreen");
        j.g(str, "compatibilityKey");
        return b(new b(t10, q.j()), b10, str);
    }

    public static final <B, T> b<B, T> b(b<T> bVar, B b10, String str) {
        j.g(bVar, "<this>");
        j.g(b10, "baseScreen");
        j.g(str, "compatibilityKey");
        return new b<>(b10, p.e(bVar), str);
    }
}
