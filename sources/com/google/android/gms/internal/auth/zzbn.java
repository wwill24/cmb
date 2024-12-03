package com.google.android.gms.internal.auth;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbn extends zzbd {
    final /* synthetic */ TaskCompletionSource zza;

    zzbn(zzbo zzbo, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzc(String str) throws RemoteException {
        Status status;
        if (str != null) {
            status = Status.f38500g;
        } else {
            status = new Status(3006);
        }
        w.b(status, str, this.zza);
    }
}
