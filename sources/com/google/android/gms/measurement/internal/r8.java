package com.google.android.gms.measurement.internal;

final class r8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final long f40228a;

    /* renamed from: b  reason: collision with root package name */
    final long f40229b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ s8 f40230c;

    r8(s8 s8Var, long j10, long j11) {
        this.f40230c = s8Var;
        this.f40228a = j10;
        this.f40229b = j11;
    }

    public final void run() {
        this.f40230c.f40266b.f40059a.f().z(new q8(this));
    }
}
