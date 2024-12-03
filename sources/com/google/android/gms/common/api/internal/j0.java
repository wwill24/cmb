package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.p;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

final class j0 implements d.c {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f38643a;

    /* renamed from: b  reason: collision with root package name */
    private final a f38644b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final boolean f38645c;

    public j0(u0 u0Var, a aVar, boolean z10) {
        this.f38643a = new WeakReference(u0Var);
        this.f38644b = aVar;
        this.f38645c = z10;
    }

    public final void a(@NonNull ConnectionResult connectionResult) {
        boolean z10;
        Lock z11;
        u0 u0Var = (u0) this.f38643a.get();
        if (u0Var != null) {
            if (Looper.myLooper() == u0Var.f38747a.f38585p.l()) {
                z10 = true;
            } else {
                z10 = false;
            }
            p.p(z10, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            u0Var.f38748b.lock();
            try {
                if (!u0Var.o(0)) {
                    z11 = u0Var.f38748b;
                } else {
                    if (!connectionResult.i0()) {
                        u0Var.m(connectionResult, this.f38644b, this.f38645c);
                    }
                    if (u0Var.p()) {
                        u0Var.n();
                    }
                    z11 = u0Var.f38748b;
                }
                z11.unlock();
            } catch (Throwable th2) {
                u0Var.f38748b.unlock();
                throw th2;
            }
        }
    }
}
