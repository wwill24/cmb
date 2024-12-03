package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class z2 extends v1 {

    /* renamed from: b  reason: collision with root package name */
    private final v f38857b;

    /* renamed from: c  reason: collision with root package name */
    private final TaskCompletionSource f38858c;

    /* renamed from: d  reason: collision with root package name */
    private final t f38859d;

    public z2(int i10, v vVar, TaskCompletionSource taskCompletionSource, t tVar) {
        super(i10);
        this.f38858c = taskCompletionSource;
        this.f38857b = vVar;
        this.f38859d = tVar;
        if (i10 == 2 && vVar.c()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    public final void a(@NonNull Status status) {
        this.f38858c.trySetException(this.f38859d.getException(status));
    }

    public final void b(@NonNull Exception exc) {
        this.f38858c.trySetException(exc);
    }

    public final void c(l1 l1Var) throws DeadObjectException {
        try {
            this.f38857b.b(l1Var.v(), this.f38858c);
        } catch (DeadObjectException e10) {
            throw e10;
        } catch (RemoteException e11) {
            a(b3.e(e11));
        } catch (RuntimeException e12) {
            this.f38858c.trySetException(e12);
        }
    }

    public final void d(@NonNull b0 b0Var, boolean z10) {
        b0Var.d(this.f38858c, z10);
    }

    public final boolean f(l1 l1Var) {
        return this.f38857b.c();
    }

    public final Feature[] g(l1 l1Var) {
        return this.f38857b.e();
    }
}
