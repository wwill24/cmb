package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcm extends zzp {
    final /* synthetic */ TaskCompletionSource zza;

    zzcm(zzda zzda, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(Status status, Location location) {
        w.b(status, location, this.zza);
    }
}
