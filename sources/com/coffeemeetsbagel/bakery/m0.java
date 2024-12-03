package com.coffeemeetsbagel.bakery;

import android.content.Context;
import fj.d;
import fj.g;
import fk.a;
import r7.f;

public final class m0 implements d<f> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f11272a;

    public m0(a<Context> aVar) {
        this.f11272a = aVar;
    }

    public static m0 a(a<Context> aVar) {
        return new m0(aVar);
    }

    public static f c(Context context) {
        return (f) g.e(c.K(context));
    }

    /* renamed from: b */
    public f get() {
        return c(this.f11272a.get());
    }
}
