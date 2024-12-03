package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.i;

final class o1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ConnectionResult f38703a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ p1 f38704b;

    o1(p1 p1Var, ConnectionResult connectionResult) {
        this.f38704b = p1Var;
        this.f38703a = connectionResult;
    }

    public final void run() {
        p1 p1Var = this.f38704b;
        l1 l1Var = (l1) p1Var.f38730f.f38619l.get(p1Var.f38726b);
        if (l1Var != null) {
            if (this.f38703a.i0()) {
                this.f38704b.f38729e = true;
                if (this.f38704b.f38725a.requiresSignIn()) {
                    this.f38704b.h();
                    return;
                }
                try {
                    p1 p1Var2 = this.f38704b;
                    p1Var2.f38725a.getRemoteService((i) null, p1Var2.f38725a.getScopesForConnectionlessNonSignIn());
                } catch (SecurityException unused) {
                    this.f38704b.f38725a.disconnect("Failed to get service from broker.");
                    l1Var.H(new ConnectionResult(10), (Exception) null);
                }
            } else {
                l1Var.H(this.f38703a, (Exception) null);
            }
        }
    }
}
