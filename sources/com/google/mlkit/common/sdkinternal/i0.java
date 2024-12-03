package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.internal.p;
import java.io.Closeable;

final class i0 implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f21409a;

    /* synthetic */ i0(n nVar, h0 h0Var) {
        boolean z10;
        this.f21409a = nVar;
        if (((Thread) nVar.f21451d.getAndSet(Thread.currentThread())) == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.o(z10);
    }

    public final void close() {
        this.f21409a.f21451d.set((Object) null);
        this.f21409a.d();
    }
}
