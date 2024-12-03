package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.p;
import we.d;

final class w7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f40386a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f40387b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzac f40388c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzac f40389d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ g8 f40390e;

    w7(g8 g8Var, boolean z10, zzq zzq, boolean z11, zzac zzac, zzac zzac2) {
        this.f40390e = g8Var;
        this.f40386a = zzq;
        this.f40387b = z11;
        this.f40388c = zzac;
        this.f40389d = zzac2;
    }

    public final void run() {
        zzac zzac;
        g8 g8Var = this.f40390e;
        d H = g8Var.f39878d;
        if (H == null) {
            g8Var.f40059a.d().r().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        p.k(this.f40386a);
        g8 g8Var2 = this.f40390e;
        if (this.f40387b) {
            zzac = null;
        } else {
            zzac = this.f40388c;
        }
        g8Var2.r(H, zzac, this.f40386a);
        this.f40390e.E();
    }
}
