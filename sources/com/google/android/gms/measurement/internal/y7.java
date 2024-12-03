package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.ArrayList;
import we.d;

final class y7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f40433a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f40434b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzq f40435c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzcf f40436d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ g8 f40437e;

    y7(g8 g8Var, String str, String str2, zzq zzq, zzcf zzcf) {
        this.f40437e = g8Var;
        this.f40433a = str;
        this.f40434b = str2;
        this.f40435c = zzq;
        this.f40436d = zzcf;
    }

    public final void run() {
        u4 u4Var;
        ArrayList arrayList = new ArrayList();
        try {
            g8 g8Var = this.f40437e;
            d H = g8Var.f39878d;
            if (H == null) {
                g8Var.f40059a.d().r().c("Failed to get conditional properties; not connected to service", this.f40433a, this.f40434b);
                u4Var = this.f40437e.f40059a;
            } else {
                p.k(this.f40435c);
                arrayList = t9.v(H.Z(this.f40433a, this.f40434b, this.f40435c));
                this.f40437e.E();
                u4Var = this.f40437e.f40059a;
            }
        } catch (RemoteException e10) {
            this.f40437e.f40059a.d().r().d("Failed to get conditional properties; remote exception", this.f40433a, this.f40434b, e10);
            u4Var = this.f40437e.f40059a;
        } catch (Throwable th2) {
            this.f40437e.f40059a.N().F(this.f40436d, arrayList);
            throw th2;
        }
        u4Var.N().F(this.f40436d, arrayList);
    }
}
