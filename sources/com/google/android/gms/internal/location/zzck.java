package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzck implements zzcs {
    final /* synthetic */ k zza;
    final /* synthetic */ TaskCompletionSource zzb;

    zzck(zzda zzda, k kVar, TaskCompletionSource taskCompletionSource) {
        this.zza = kVar;
        this.zzb = taskCompletionSource;
    }

    public final k zza() {
        return this.zza;
    }

    public final void zzb() {
        this.zzb.trySetResult(null);
    }

    public final void zzc(k kVar) {
        throw new IllegalStateException();
    }
}
