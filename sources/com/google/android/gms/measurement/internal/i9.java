package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.p;
import java.util.concurrent.Callable;
import we.o;

final class i9 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f39946a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ n9 f39947b;

    i9(n9 n9Var, zzq zzq) {
        this.f39947b = n9Var;
        this.f39946a = zzq;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        o c02 = this.f39947b.c0((String) p.k(this.f39946a.f40506a));
        zzha zzha = zzha.ANALYTICS_STORAGE;
        if (c02.j(zzha) && o.c(this.f39946a.C, 100).j(zzha)) {
            return this.f39947b.S(this.f39946a).m0();
        }
        this.f39947b.d().v().a("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
