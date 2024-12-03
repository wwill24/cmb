package com.google.android.gms.internal.appset;

import com.google.android.gms.appset.zzc;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.tasks.TaskCompletionSource;
import td.c;

final class zzo extends zze {
    final /* synthetic */ TaskCompletionSource zza;

    zzo(zzp zzp, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(Status status, zzc zzc) {
        c cVar;
        if (zzc != null) {
            cVar = new c(zzc.zzb(), zzc.zza());
        } else {
            cVar = null;
        }
        w.b(status, cVar, this.zza);
    }
}
