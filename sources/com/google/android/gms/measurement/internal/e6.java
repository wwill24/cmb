package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class e6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f39762a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f39763b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f39764c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ u6 f39765d;

    e6(u6 u6Var, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f39765d = u6Var;
        this.f39762a = atomicReference;
        this.f39763b = str2;
        this.f39764c = str3;
    }

    public final void run() {
        this.f39765d.f40059a.L().U(this.f39762a, (String) null, this.f39763b, this.f39764c);
    }
}
