package com.google.android.gms.measurement.internal;

final class g5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzau f39859a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f39860b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ m5 f39861c;

    g5(m5 m5Var, zzau zzau, String str) {
        this.f39861c = m5Var;
        this.f39859a = zzau;
        this.f39860b = str;
    }

    public final void run() {
        this.f39861c.f40032a.e();
        this.f39861c.f40032a.k(this.f39859a, this.f39860b);
    }
}
