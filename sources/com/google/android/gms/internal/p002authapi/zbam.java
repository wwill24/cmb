package com.google.android.gms.internal.p002authapi;

import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbam  reason: invalid package */
final class zbam extends zbae {
    final /* synthetic */ TaskCompletionSource zba;

    zbam(zbao zbao, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    public final void zbb(Status status, SaveAccountLinkingTokenResult saveAccountLinkingTokenResult) throws RemoteException {
        if (status.i0()) {
            this.zba.setResult(saveAccountLinkingTokenResult);
        } else {
            this.zba.setException(b.a(status));
        }
    }
}
