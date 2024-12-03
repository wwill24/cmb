package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class a7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bundle f39644a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ z6 f39645b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ z6 f39646c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ long f39647d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ g7 f39648e;

    a7(g7 g7Var, Bundle bundle, z6 z6Var, z6 z6Var2, long j10) {
        this.f39648e = g7Var;
        this.f39644a = bundle;
        this.f39645b = z6Var;
        this.f39646c = z6Var2;
        this.f39647d = j10;
    }

    public final void run() {
        g7.w(this.f39648e, this.f39644a, this.f39645b, this.f39646c, this.f39647d);
    }
}
