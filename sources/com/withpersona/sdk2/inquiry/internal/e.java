package com.withpersona.sdk2.inquiry.internal;

import android.content.Context;
import fj.d;
import fj.g;

public final class e implements d<Context> {

    /* renamed from: a  reason: collision with root package name */
    private final d f26329a;

    public e(d dVar) {
        this.f26329a = dVar;
    }

    public static Context a(d dVar) {
        return (Context) g.e(dVar.a());
    }

    public static e b(d dVar) {
        return new e(dVar);
    }

    /* renamed from: c */
    public Context get() {
        return a(this.f26329a);
    }
}
