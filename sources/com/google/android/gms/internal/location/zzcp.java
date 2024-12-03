package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.location.m0;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcp extends zzj {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ m0 zzb;

    zzcp(TaskCompletionSource taskCompletionSource, m0 m0Var) {
        this.zza = taskCompletionSource;
        this.zzb = m0Var;
    }

    public final void zzd(zzg zzg) {
        w.a(zzg.getStatus(), this.zza);
    }

    public final void zze() throws RemoteException {
        this.zzb.zzf();
    }
}
