package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.measurement.zzcf;
import we.d;

final class m7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f40037a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzcf f40038b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ g8 f40039c;

    m7(g8 g8Var, zzq zzq, zzcf zzcf) {
        this.f40039c = g8Var;
        this.f40037a = zzq;
        this.f40038b = zzcf;
    }

    public final void run() {
        u4 u4Var;
        String str = null;
        try {
            if (!this.f40039c.f40059a.F().q().j(zzha.ANALYTICS_STORAGE)) {
                this.f40039c.f40059a.d().x().a("Analytics storage consent denied; will not get app instance id");
                this.f40039c.f40059a.I().C((String) null);
                this.f40039c.f40059a.F().f39742g.b((String) null);
                u4Var = this.f40039c.f40059a;
            } else {
                g8 g8Var = this.f40039c;
                d H = g8Var.f39878d;
                if (H == null) {
                    g8Var.f40059a.d().r().a("Failed to get app instance id");
                    u4Var = this.f40039c.f40059a;
                } else {
                    p.k(this.f40037a);
                    str = H.M(this.f40037a);
                    if (str != null) {
                        this.f40039c.f40059a.I().C(str);
                        this.f40039c.f40059a.F().f39742g.b(str);
                    }
                    this.f40039c.E();
                    u4Var = this.f40039c.f40059a;
                }
            }
        } catch (RemoteException e10) {
            this.f40039c.f40059a.d().r().b("Failed to get app instance id", e10);
            u4Var = this.f40039c.f40059a;
        } catch (Throwable th2) {
            this.f40039c.f40059a.N().K(this.f40038b, (String) null);
            throw th2;
        }
        u4Var.N().K(this.f40038b, str);
    }
}
