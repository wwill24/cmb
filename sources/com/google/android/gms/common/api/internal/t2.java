package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class t2 extends v1 {

    /* renamed from: b  reason: collision with root package name */
    protected final TaskCompletionSource f38743b;

    public t2(int i10, TaskCompletionSource taskCompletionSource) {
        super(i10);
        this.f38743b = taskCompletionSource;
    }

    public final void a(@NonNull Status status) {
        this.f38743b.trySetException(new ApiException(status));
    }

    public final void b(@NonNull Exception exc) {
        this.f38743b.trySetException(exc);
    }

    public final void c(l1 l1Var) throws DeadObjectException {
        try {
            h(l1Var);
        } catch (DeadObjectException e10) {
            a(b3.e(e10));
            throw e10;
        } catch (RemoteException e11) {
            a(b3.e(e11));
        } catch (RuntimeException e12) {
            this.f38743b.trySetException(e12);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void h(l1 l1Var) throws RemoteException;
}
