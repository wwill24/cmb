package com.google.android.gms.measurement.internal;

final class m8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n9 f40040a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Runnable f40041b;

    m8(n8 n8Var, n9 n9Var, Runnable runnable) {
        this.f40040a = n9Var;
        this.f40041b = runnable;
    }

    public final void run() {
        this.f40040a.e();
        this.f40040a.l0(this.f40041b);
        this.f40040a.C();
    }
}
