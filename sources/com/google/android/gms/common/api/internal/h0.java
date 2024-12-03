package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.p;
import java.util.Set;

public final class h0 implements a1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d1 f38630a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f38631b = false;

    public h0(d1 d1Var) {
        this.f38630a = d1Var;
    }

    public final void a(Bundle bundle) {
    }

    public final void b() {
    }

    public final void c() {
        if (this.f38631b) {
            this.f38631b = false;
            this.f38630a.r(new g0(this, this));
        }
    }

    public final void d(ConnectionResult connectionResult, a aVar, boolean z10) {
    }

    public final void e(int i10) {
        this.f38630a.q((ConnectionResult) null);
        this.f38630a.f38586q.b(i10, this.f38631b);
    }

    public final d f(d dVar) {
        h(dVar);
        return dVar;
    }

    public final boolean g() {
        if (this.f38631b) {
            return false;
        }
        Set<u2> set = this.f38630a.f38585p.f38850w;
        if (set == null || set.isEmpty()) {
            this.f38630a.q((ConnectionResult) null);
            return true;
        }
        this.f38631b = true;
        for (u2 j10 : set) {
            j10.j();
        }
        return false;
    }

    public final d h(d dVar) {
        try {
            this.f38630a.f38585p.f38851x.a(dVar);
            z0 z0Var = this.f38630a.f38585p;
            a.f fVar = (a.f) z0Var.f38842o.get(dVar.getClientKey());
            p.l(fVar, "Appropriate Api was not requested.");
            if (fVar.isConnected() || !this.f38630a.f38578g.containsKey(dVar.getClientKey())) {
                dVar.run(fVar);
            } else {
                dVar.setFailedResult(new Status(17));
            }
        } catch (DeadObjectException unused) {
            this.f38630a.r(new f0(this, this));
        }
        return dVar;
    }

    /* access modifiers changed from: package-private */
    public final void j() {
        if (this.f38631b) {
            this.f38631b = false;
            this.f38630a.f38585p.f38851x.b();
            g();
        }
    }
}
