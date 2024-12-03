package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.m;
import com.google.android.gms.common.internal.p;

final class r2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f38735a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ u2 f38736b;

    r2(u2 u2Var, j jVar) {
        this.f38736b = u2Var;
        this.f38735a = jVar;
    }

    public final void run() {
        d dVar;
        try {
            ThreadLocal threadLocal = BasePendingResult.zaa;
            threadLocal.set(Boolean.TRUE);
            f b10 = ((m) p.k(this.f38736b.f38768a)).b(this.f38735a);
            u2 u2Var = this.f38736b;
            u2Var.f38775h.sendMessage(u2Var.f38775h.obtainMessage(0, b10));
            threadLocal.set(Boolean.FALSE);
            u2.p(this.f38735a);
            dVar = (d) this.f38736b.f38774g.get();
            if (dVar == null) {
                return;
            }
        } catch (RuntimeException e10) {
            u2 u2Var2 = this.f38736b;
            u2Var2.f38775h.sendMessage(u2Var2.f38775h.obtainMessage(1, e10));
            BasePendingResult.zaa.set(Boolean.FALSE);
            u2.p(this.f38735a);
            dVar = (d) this.f38736b.f38774g.get();
            if (dVar == null) {
                return;
            }
        } catch (Throwable th2) {
            BasePendingResult.zaa.set(Boolean.FALSE);
            u2.p(this.f38735a);
            d dVar2 = (d) this.f38736b.f38774g.get();
            if (dVar2 != null) {
                dVar2.t(this.f38736b);
            }
            throw th2;
        }
        dVar.t(this.f38736b);
    }
}
