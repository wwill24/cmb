package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.h;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcl extends h.a {
    final /* synthetic */ Object zza;
    final /* synthetic */ TaskCompletionSource zzb;

    zzcl(zzda zzda, Object obj, TaskCompletionSource taskCompletionSource) {
        this.zza = obj;
        this.zzb = taskCompletionSource;
    }

    public final void onResult(Status status) {
        w.b(status, this.zza, this.zzb);
    }
}
