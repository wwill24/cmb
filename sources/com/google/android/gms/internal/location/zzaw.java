package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzaw implements q {
    public final /* synthetic */ Location zza;

    public /* synthetic */ zzaw(Location location) {
        this.zza = location;
    }

    public final void accept(Object obj, Object obj2) {
        a aVar = zzbp.zzb;
        ((zzda) obj).zzz(this.zza, (TaskCompletionSource) obj2);
    }
}
