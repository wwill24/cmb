package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzbh implements q {
    public final /* synthetic */ CurrentLocationRequest zza;
    public final /* synthetic */ CancellationToken zzb;

    public /* synthetic */ zzbh(CurrentLocationRequest currentLocationRequest, CancellationToken cancellationToken) {
        this.zza = currentLocationRequest;
        this.zzb = cancellationToken;
    }

    public final void accept(Object obj, Object obj2) {
        a aVar = zzbp.zzb;
        ((zzda) obj).zzs(this.zza, this.zzb, (TaskCompletionSource) obj2);
    }
}
