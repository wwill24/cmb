package com.skydoves.balloon.internals;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import tk.d;
import wk.l;

public final class b<T> implements d<Object, T> {

    /* renamed from: a  reason: collision with root package name */
    private final Function0<Unit> f22803a;

    /* renamed from: b  reason: collision with root package name */
    private T f22804b;

    public b(T t10, Function0<Unit> function0) {
        j.g(function0, "invalidator");
        this.f22803a = function0;
        this.f22804b = t10;
    }

    public T getValue(Object obj, l<?> lVar) {
        j.g(lVar, "property");
        return this.f22804b;
    }

    public void setValue(Object obj, l<?> lVar, T t10) {
        j.g(lVar, "property");
        if (!j.b(this.f22804b, t10)) {
            this.f22804b = t10;
            this.f22803a.invoke();
        }
    }
}
