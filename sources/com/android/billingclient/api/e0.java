package com.android.billingclient.api;

import java.util.concurrent.Callable;

final class e0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f8882a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ q f8883b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ f f8884c;

    e0(f fVar, String str, q qVar) {
        this.f8884c = fVar;
        this.f8882a = str;
        this.f8883b = qVar;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        k0 F = f.F(this.f8884c, this.f8882a);
        this.f8883b.a(F.a(), F.b());
        return null;
    }
}
