package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import we.d;

final class n7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f40062a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g8 f40063b;

    n7(g8 g8Var, zzq zzq) {
        this.f40063b = g8Var;
        this.f40062a = zzq;
    }

    public final void run() {
        g8 g8Var = this.f40063b;
        d H = g8Var.f39878d;
        if (H == null) {
            g8Var.f40059a.d().r().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            p.k(this.f40062a);
            H.s(this.f40062a);
            this.f40063b.f40059a.C().t();
            this.f40063b.r(H, (AbstractSafeParcelable) null, this.f40062a);
            this.f40063b.E();
        } catch (RemoteException e10) {
            this.f40063b.f40059a.d().r().b("Failed to send app launch to the service", e10);
        }
    }
}
