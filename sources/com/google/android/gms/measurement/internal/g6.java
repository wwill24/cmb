package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class g6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f39862a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f39863b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f39864c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f39865d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ u6 f39866e;

    g6(u6 u6Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z10) {
        this.f39866e = u6Var;
        this.f39862a = atomicReference;
        this.f39863b = str2;
        this.f39864c = str3;
        this.f39865d = z10;
    }

    public final void run() {
        this.f39866e.f40059a.L().W(this.f39862a, (String) null, this.f39863b, this.f39864c, this.f39865d);
    }
}
