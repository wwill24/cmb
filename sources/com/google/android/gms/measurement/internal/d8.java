package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

final class d8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f8 f39725a;

    d8(f8 f8Var) {
        this.f39725a = f8Var;
    }

    public final void run() {
        g8 g8Var = this.f39725a.f39796c;
        Context c10 = g8Var.f40059a.c();
        this.f39725a.f39796c.f40059a.b();
        g8.M(g8Var, new ComponentName(c10, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
