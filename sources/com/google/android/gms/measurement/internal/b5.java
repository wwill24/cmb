package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class b5 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f39674a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f39675b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f39676c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ m5 f39677d;

    b5(m5 m5Var, String str, String str2, String str3) {
        this.f39677d = m5Var;
        this.f39674a = str;
        this.f39675b = str2;
        this.f39676c = str3;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        this.f39677d.f40032a.e();
        return this.f39677d.f40032a.V().a0(this.f39674a, this.f39675b, this.f39676c);
    }
}
