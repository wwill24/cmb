package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcn extends zzj {
    final /* synthetic */ Object zza;
    final /* synthetic */ TaskCompletionSource zzb;

    zzcn(Object obj, TaskCompletionSource taskCompletionSource) {
        this.zza = obj;
        this.zzb = taskCompletionSource;
    }

    public final void zzd(zzg zzg) {
        w.b(zzg.getStatus(), this.zza, this.zzb);
    }

    public final void zze() {
    }
}
