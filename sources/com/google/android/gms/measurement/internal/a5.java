package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class a5 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f39635a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f39636b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f39637c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ m5 f39638d;

    a5(m5 m5Var, String str, String str2, String str3) {
        this.f39638d = m5Var;
        this.f39635a = str;
        this.f39636b = str2;
        this.f39637c = str3;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        this.f39638d.f40032a.e();
        return this.f39638d.f40032a.V().a0(this.f39635a, this.f39636b, this.f39637c);
    }
}
