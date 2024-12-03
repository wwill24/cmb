package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class y2 extends t2 {

    /* renamed from: c  reason: collision with root package name */
    public final d2 f38826c;

    public y2(d2 d2Var, TaskCompletionSource taskCompletionSource) {
        super(3, taskCompletionSource);
        this.f38826c = d2Var;
    }

    public final /* bridge */ /* synthetic */ void d(@NonNull b0 b0Var, boolean z10) {
    }

    public final boolean f(l1 l1Var) {
        return this.f38826c.f38587a.f();
    }

    public final Feature[] g(l1 l1Var) {
        return this.f38826c.f38587a.c();
    }

    public final void h(l1 l1Var) throws RemoteException {
        this.f38826c.f38587a.d(l1Var.v(), this.f38743b);
        k.a b10 = this.f38826c.f38587a.b();
        if (b10 != null) {
            l1Var.x().put(b10, this.f38826c);
        }
    }
}
