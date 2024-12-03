package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import we.d;

final class o7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z6 f40117a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g8 f40118b;

    o7(g8 g8Var, z6 z6Var) {
        this.f40118b = g8Var;
        this.f40117a = z6Var;
    }

    public final void run() {
        g8 g8Var = this.f40118b;
        d H = g8Var.f39878d;
        if (H == null) {
            g8Var.f40059a.d().r().a("Failed to send current screen to service");
            return;
        }
        try {
            z6 z6Var = this.f40117a;
            if (z6Var == null) {
                H.v(0, (String) null, (String) null, g8Var.f40059a.c().getPackageName());
            } else {
                H.v(z6Var.f40465c, z6Var.f40463a, z6Var.f40464b, g8Var.f40059a.c().getPackageName());
            }
            this.f40118b.E();
        } catch (RemoteException e10) {
            this.f40118b.f40059a.d().r().b("Failed to send current screen to the service", e10);
        }
    }
}
