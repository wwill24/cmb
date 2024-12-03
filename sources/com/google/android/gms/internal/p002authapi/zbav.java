package com.google.android.gms.internal.p002authapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.h;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbav  reason: invalid package */
final class zbav extends h.a {
    final /* synthetic */ TaskCompletionSource zba;

    zbav(zbay zbay, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    public final void onResult(Status status) throws RemoteException {
        w.a(status, this.zba);
    }
}
