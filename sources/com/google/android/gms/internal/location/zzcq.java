package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.k;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcq extends zzr {
    final /* synthetic */ TaskCompletionSource zza;

    zzcq(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(LocationSettingsResult locationSettingsResult) {
        w.b(locationSettingsResult.getStatus(), new k(locationSettingsResult), this.zza);
    }
}
