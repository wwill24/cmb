package com.google.android.gms.internal.fido;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzx extends zzu {
    final /* synthetic */ TaskCompletionSource zza;

    zzx(zzy zzy, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(Status status, PendingIntent pendingIntent) throws RemoteException {
        w.b(status, pendingIntent, this.zza);
    }
}
