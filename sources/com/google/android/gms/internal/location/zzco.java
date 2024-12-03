package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.location.p0;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzco extends zzj {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ p0 zzb;

    zzco(TaskCompletionSource taskCompletionSource, p0 p0Var) {
        this.zza = taskCompletionSource;
        this.zzb = p0Var;
    }

    public final void zzd(zzg zzg) {
        w.a(zzg.getStatus(), this.zza);
    }

    public final void zze() throws RemoteException {
        this.zzb.zze();
    }
}
