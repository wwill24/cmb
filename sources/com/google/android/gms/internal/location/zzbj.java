package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzbj implements q {
    public final /* synthetic */ LastLocationRequest zza;

    public /* synthetic */ zzbj(LastLocationRequest lastLocationRequest) {
        this.zza = lastLocationRequest;
    }

    public final void accept(Object obj, Object obj2) {
        a aVar = zzbp.zzb;
        ((zzda) obj).zzt(this.zza, (TaskCompletionSource) obj2);
    }
}
