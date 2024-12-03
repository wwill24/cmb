package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.p;
import we.d;

final class v7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f40365a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f40366b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzau f40367c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ String f40368d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ g8 f40369e;

    v7(g8 g8Var, boolean z10, zzq zzq, boolean z11, zzau zzau, String str) {
        this.f40369e = g8Var;
        this.f40365a = zzq;
        this.f40366b = z11;
        this.f40367c = zzau;
        this.f40368d = str;
    }

    public final void run() {
        zzau zzau;
        g8 g8Var = this.f40369e;
        d H = g8Var.f39878d;
        if (H == null) {
            g8Var.f40059a.d().r().a("Discarding data. Failed to send event to service");
            return;
        }
        p.k(this.f40365a);
        g8 g8Var2 = this.f40369e;
        if (this.f40366b) {
            zzau = null;
        } else {
            zzau = this.f40367c;
        }
        g8Var2.r(H, zzau, this.f40365a);
        this.f40369e.E();
    }
}
