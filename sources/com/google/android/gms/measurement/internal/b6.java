package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class b6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f39678a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ u6 f39679b;

    b6(u6 u6Var, long j10) {
        this.f39679b = u6Var;
        this.f39678a = j10;
    }

    public final void run() {
        this.f39679b.z(this.f39678a, true);
        this.f39679b.f40059a.L().S(new AtomicReference());
    }
}
