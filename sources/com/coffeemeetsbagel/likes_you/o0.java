package com.coffeemeetsbagel.likes_you;

import android.content.Context;
import fj.d;
import fk.a;

public final class o0 implements d<n0> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f34245a;

    public o0(a<Context> aVar) {
        this.f34245a = aVar;
    }

    public static o0 a(a<Context> aVar) {
        return new o0(aVar);
    }

    public static n0 c(Context context) {
        return new n0(context);
    }

    /* renamed from: b */
    public n0 get() {
        return c(this.f34245a.get());
    }
}
