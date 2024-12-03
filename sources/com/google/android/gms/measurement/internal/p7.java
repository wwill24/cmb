package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.p;
import we.d;

final class p7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f40140a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Bundle f40141b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ g8 f40142c;

    p7(g8 g8Var, zzq zzq, Bundle bundle) {
        this.f40142c = g8Var;
        this.f40140a = zzq;
        this.f40141b = bundle;
    }

    public final void run() {
        g8 g8Var = this.f40142c;
        d H = g8Var.f39878d;
        if (H == null) {
            g8Var.f40059a.d().r().a("Failed to send default event parameters to service");
            return;
        }
        try {
            p.k(this.f40140a);
            H.J(this.f40141b, this.f40140a);
        } catch (RemoteException e10) {
            this.f40142c.f40059a.d().r().b("Failed to send default event parameters to service", e10);
        }
    }
}
