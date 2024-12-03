package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzay implements q {
    public final /* synthetic */ zzbo zza;
    public final /* synthetic */ LocationRequest zzb;

    public /* synthetic */ zzay(zzbo zzbo, LocationRequest locationRequest) {
        this.zza = zzbo;
        this.zzb = locationRequest;
    }

    public final void accept(Object obj, Object obj2) {
        a aVar = zzbp.zzb;
        ((zzda) obj).zzu(this.zza, this.zzb, (TaskCompletionSource) obj2);
    }
}
