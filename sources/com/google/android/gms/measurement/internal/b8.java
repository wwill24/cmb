package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

final class b8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ComponentName f39685a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ f8 f39686b;

    b8(f8 f8Var, ComponentName componentName) {
        this.f39686b = f8Var;
        this.f39685a = componentName;
    }

    public final void run() {
        g8.M(this.f39686b.f39796c, this.f39685a);
    }
}
