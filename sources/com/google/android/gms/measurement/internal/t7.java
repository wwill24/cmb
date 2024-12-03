package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.p;
import we.d;

final class t7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f40282a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g8 f40283b;

    t7(g8 g8Var, zzq zzq) {
        this.f40283b = g8Var;
        this.f40282a = zzq;
    }

    public final void run() {
        g8 g8Var = this.f40283b;
        d H = g8Var.f39878d;
        if (H == null) {
            g8Var.f40059a.d().r().a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            p.k(this.f40282a);
            H.H(this.f40282a);
            this.f40283b.E();
        } catch (RemoteException e10) {
            this.f40283b.f40059a.d().r().b("Failed to send measurementEnabled to the service", e10);
        }
    }
}
