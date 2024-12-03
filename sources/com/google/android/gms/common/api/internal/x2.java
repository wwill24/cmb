package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.p;

public final class x2 extends b3 {

    /* renamed from: b  reason: collision with root package name */
    protected final d f38805b;

    public x2(int i10, d dVar) {
        super(i10);
        this.f38805b = (d) p.l(dVar, "Null methods are not runnable.");
    }

    public final void a(@NonNull Status status) {
        try {
            this.f38805b.setFailedResult(status);
        } catch (IllegalStateException unused) {
        }
    }

    public final void b(@NonNull Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String localizedMessage = exc.getLocalizedMessage();
        try {
            this.f38805b.setFailedResult(new Status(10, simpleName + ": " + localizedMessage));
        } catch (IllegalStateException unused) {
        }
    }

    public final void c(l1 l1Var) throws DeadObjectException {
        try {
            this.f38805b.run(l1Var.v());
        } catch (RuntimeException e10) {
            b(e10);
        }
    }

    public final void d(@NonNull b0 b0Var, boolean z10) {
        b0Var.c(this.f38805b, z10);
    }
}
