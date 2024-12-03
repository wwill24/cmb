package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.p;
import we.d;

final class k7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f39993a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g8 f39994b;

    k7(g8 g8Var, zzq zzq) {
        this.f39994b = g8Var;
        this.f39993a = zzq;
    }

    public final void run() {
        g8 g8Var = this.f39994b;
        d H = g8Var.f39878d;
        if (H == null) {
            g8Var.f40059a.d().r().a("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            p.k(this.f39993a);
            H.B(this.f39993a);
        } catch (RemoteException e10) {
            this.f39994b.f40059a.d().r().b("Failed to reset data on the service: remote exception", e10);
        }
        this.f39994b.E();
    }
}
