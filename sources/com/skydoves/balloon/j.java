package com.skydoves.balloon;

import android.view.View;
import gk.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.f;

final /* synthetic */ class j implements o, f {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Function1 f22805a;

    j(Function1 function1) {
        kotlin.jvm.internal.j.g(function1, "function");
        this.f22805a = function1;
    }

    public final c<?> a() {
        return this.f22805a;
    }

    public final /* synthetic */ void b(View view) {
        this.f22805a.invoke(view);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof o) || !(obj instanceof f)) {
            return false;
        }
        return kotlin.jvm.internal.j.b(a(), ((f) obj).a());
    }

    public final int hashCode() {
        return a().hashCode();
    }
}
