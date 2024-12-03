package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.p;
import we.d;

final class u7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f40341a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g8 f40342b;

    u7(g8 g8Var, zzq zzq) {
        this.f40342b = g8Var;
        this.f40341a = zzq;
    }

    public final void run() {
        g8 g8Var = this.f40342b;
        d H = g8Var.f39878d;
        if (H == null) {
            g8Var.f40059a.d().r().a("Failed to send consent settings to service");
            return;
        }
        try {
            p.k(this.f40341a);
            H.y(this.f40341a);
            this.f40342b.E();
        } catch (RemoteException e10) {
            this.f40342b.f40059a.d().r().b("Failed to send consent settings to the service", e10);
        }
    }
}
