package com.google.android.gms.internal.p002authapi;

import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zban  reason: invalid package */
final class zban extends zbag {
    final /* synthetic */ TaskCompletionSource zba;

    zban(zbao zbao, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    public final void zbb(Status status, SavePasswordResult savePasswordResult) throws RemoteException {
        w.b(status, savePasswordResult, this.zba);
    }
}
