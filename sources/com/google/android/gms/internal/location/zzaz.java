package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzaz implements q {
    public final /* synthetic */ PendingIntent zza;
    public final /* synthetic */ LocationRequest zzb;

    public /* synthetic */ zzaz(PendingIntent pendingIntent, LocationRequest locationRequest) {
        this.zza = pendingIntent;
        this.zzb = locationRequest;
    }

    public final void accept(Object obj, Object obj2) {
        a aVar = zzbp.zzb;
        ((zzda) obj).zzw(this.zza, this.zzb, (TaskCompletionSource) obj2);
    }
}
