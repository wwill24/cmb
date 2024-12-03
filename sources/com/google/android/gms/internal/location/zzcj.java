package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.h;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcj extends h {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzda zzb;

    zzcj(zzda zzda, TaskCompletionSource taskCompletionSource) {
        this.zzb = zzda;
        this.zza = taskCompletionSource;
    }

    public final void onLocationResult(LocationResult locationResult) {
        this.zza.trySetResult(locationResult.S());
        try {
            this.zzb.zzB(l.c(this, "GetCurrentLocation"), false, new TaskCompletionSource());
        } catch (RemoteException unused) {
        }
    }
}
