package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class a3 extends t2 {

    /* renamed from: c  reason: collision with root package name */
    public final k.a f38544c;

    public a3(k.a aVar, TaskCompletionSource taskCompletionSource) {
        super(4, taskCompletionSource);
        this.f38544c = aVar;
    }

    public final /* bridge */ /* synthetic */ void d(@NonNull b0 b0Var, boolean z10) {
    }

    public final boolean f(l1 l1Var) {
        d2 d2Var = (d2) l1Var.x().get(this.f38544c);
        if (d2Var == null || !d2Var.f38587a.f()) {
            return false;
        }
        return true;
    }

    public final Feature[] g(l1 l1Var) {
        d2 d2Var = (d2) l1Var.x().get(this.f38544c);
        if (d2Var == null) {
            return null;
        }
        return d2Var.f38587a.c();
    }

    public final void h(l1 l1Var) throws RemoteException {
        d2 d2Var = (d2) l1Var.x().remove(this.f38544c);
        if (d2Var != null) {
            d2Var.f38588b.b(l1Var.v(), this.f38743b);
            d2Var.f38587a.a();
            return;
        }
        this.f38743b.trySetResult(Boolean.FALSE);
    }
}
