package com.coffeemeetsbagel.store.premium_upsell;

import android.app.Activity;
import b6.d;
import c6.b;
import kotlin.jvm.internal.j;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final d<?, ?> f36903a;

    public p(d<?, ?> dVar) {
        j.g(dVar, "componentActivity");
        this.f36903a = dVar;
    }

    public final Activity a() {
        return this.f36903a;
    }

    public final b b() {
        b F0 = this.f36903a.F0();
        j.f(F0, "componentActivity.activityResultStream()");
        return F0;
    }
}
