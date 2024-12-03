package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.p;
import we.d;

final class j7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f39959a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f39960b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzlk f39961c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ g8 f39962d;

    j7(g8 g8Var, zzq zzq, boolean z10, zzlk zzlk) {
        this.f39962d = g8Var;
        this.f39959a = zzq;
        this.f39960b = z10;
        this.f39961c = zzlk;
    }

    public final void run() {
        zzlk zzlk;
        g8 g8Var = this.f39962d;
        d H = g8Var.f39878d;
        if (H == null) {
            g8Var.f40059a.d().r().a("Discarding data. Failed to set user property");
            return;
        }
        p.k(this.f39959a);
        g8 g8Var2 = this.f39962d;
        if (this.f39960b) {
            zzlk = null;
        } else {
            zzlk = this.f39961c;
        }
        g8Var2.r(H, zzlk, this.f39959a);
        this.f39962d.E();
    }
}
