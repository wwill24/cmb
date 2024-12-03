package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzy implements q {
    public final /* synthetic */ PendingIntent zza;

    public /* synthetic */ zzy(PendingIntent pendingIntent) {
        this.zza = pendingIntent;
    }

    public final void accept(Object obj, Object obj2) {
        PendingIntent pendingIntent = this.zza;
        a aVar = zzag.zzb;
        ((zzf) obj).zzp(pendingIntent);
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
