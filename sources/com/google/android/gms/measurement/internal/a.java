package com.google.android.gms.measurement.internal;

final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f39625a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f39626b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ z1 f39627c;

    a(z1 z1Var, String str, long j10) {
        this.f39627c = z1Var;
        this.f39625a = str;
        this.f39626b = j10;
    }

    public final void run() {
        z1.i(this.f39627c, this.f39625a, this.f39626b);
    }
}
