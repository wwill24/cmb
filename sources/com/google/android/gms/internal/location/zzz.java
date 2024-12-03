package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.api.internal.s;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.location.zzb;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzz implements q {
    public final /* synthetic */ zzb zza;
    public final /* synthetic */ PendingIntent zzb;

    public /* synthetic */ zzz(zzb zzb2, PendingIntent pendingIntent) {
        this.zza = zzb2;
        this.zzb = pendingIntent;
    }

    public final void accept(Object obj, Object obj2) {
        zzb zzb2 = this.zza;
        PendingIntent pendingIntent = this.zzb;
        a aVar = zzag.zzb;
        zzaf zzaf = new zzaf((TaskCompletionSource) obj2);
        p.l(zzb2, "ActivityRecognitionRequest can't be null.");
        p.l(pendingIntent, "PendingIntent must be specified.");
        p.l(zzaf, "ResultHolder not provided.");
        ((zzo) ((zzf) obj).getService()).zzs(zzb2, pendingIntent, new s(zzaf));
    }
}
