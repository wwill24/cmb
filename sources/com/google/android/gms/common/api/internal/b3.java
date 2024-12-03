package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;

public abstract class b3 {

    /* renamed from: a  reason: collision with root package name */
    public final int f38554a;

    public b3(int i10) {
        this.f38554a = i10;
    }

    static /* bridge */ /* synthetic */ Status e(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void a(@NonNull Status status);

    public abstract void b(@NonNull Exception exc);

    public abstract void c(l1 l1Var) throws DeadObjectException;

    public abstract void d(@NonNull b0 b0Var, boolean z10);
}
