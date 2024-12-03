package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.p;
import java.util.concurrent.atomic.AtomicReference;
import we.d;

final class l7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f40014a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzq f40015b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ g8 f40016c;

    l7(g8 g8Var, AtomicReference atomicReference, zzq zzq) {
        this.f40016c = g8Var;
        this.f40014a = atomicReference;
        this.f40015b = zzq;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.f40014a) {
            try {
                if (!this.f40016c.f40059a.F().q().j(zzha.ANALYTICS_STORAGE)) {
                    this.f40016c.f40059a.d().x().a("Analytics storage consent denied; will not get app instance id");
                    this.f40016c.f40059a.I().C((String) null);
                    this.f40016c.f40059a.F().f39742g.b((String) null);
                    this.f40014a.set((Object) null);
                    this.f40014a.notify();
                    return;
                }
                g8 g8Var = this.f40016c;
                d H = g8Var.f39878d;
                if (H == null) {
                    g8Var.f40059a.d().r().a("Failed to get app instance id");
                    this.f40014a.notify();
                    return;
                }
                p.k(this.f40015b);
                this.f40014a.set(H.M(this.f40015b));
                String str = (String) this.f40014a.get();
                if (str != null) {
                    this.f40016c.f40059a.I().C(str);
                    this.f40016c.f40059a.F().f39742g.b(str);
                }
                this.f40016c.E();
                atomicReference = this.f40014a;
                atomicReference.notify();
            } catch (RemoteException e10) {
                try {
                    this.f40016c.f40059a.d().r().b("Failed to get app instance id", e10);
                    atomicReference = this.f40014a;
                } catch (Throwable th2) {
                    this.f40014a.notify();
                    throw th2;
                }
            }
        }
    }
}
