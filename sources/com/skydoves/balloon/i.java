package com.skydoves.balloon;

import gk.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

final /* synthetic */ class i implements n, f {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Function0 f22802a;

    i(Function0 function0) {
        j.g(function0, "function");
        this.f22802a = function0;
    }

    public final c<?> a() {
        return this.f22802a;
    }

    public final /* synthetic */ void b() {
        this.f22802a.invoke();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n) || !(obj instanceof f)) {
            return false;
        }
        return j.b(a(), ((f) obj).a());
    }

    public final int hashCode() {
        return a().hashCode();
    }
}
