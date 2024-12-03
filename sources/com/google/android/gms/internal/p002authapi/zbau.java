package com.google.android.gms.internal.p002authapi;

import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbau  reason: invalid package */
final class zbau extends zbx {
    final /* synthetic */ TaskCompletionSource zba;

    zbau(zbay zbay, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    public final void zbb(Status status, BeginSignInResult beginSignInResult) throws RemoteException {
        w.b(status, beginSignInResult, this.zba);
    }
}
