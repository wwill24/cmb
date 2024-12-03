package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.p;
import ye.f;

final class r0 implements d.b, d.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u0 f38734a;

    /* synthetic */ r0(u0 u0Var, q0 q0Var) {
        this.f38734a = u0Var;
    }

    public final void c(Bundle bundle) {
        e eVar = (e) p.k(this.f38734a.f38764r);
        ((f) p.k(this.f38734a.f38757k)).c(new p0(this.f38734a));
    }

    public final void f(int i10) {
    }

    public final void g(@NonNull ConnectionResult connectionResult) {
        this.f38734a.f38748b.lock();
        try {
            if (this.f38734a.q(connectionResult)) {
                this.f38734a.i();
                this.f38734a.n();
            } else {
                this.f38734a.l(connectionResult);
            }
        } finally {
            this.f38734a.f38748b.unlock();
        }
    }
}
