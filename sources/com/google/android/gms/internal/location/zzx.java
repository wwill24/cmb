package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.api.internal.s;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzx implements q {
    public final /* synthetic */ PendingIntent zza;

    public /* synthetic */ zzx(PendingIntent pendingIntent) {
        this.zza = pendingIntent;
    }

    public final void accept(Object obj, Object obj2) {
        PendingIntent pendingIntent = this.zza;
        a aVar = zzag.zzb;
        zzaf zzaf = new zzaf((TaskCompletionSource) obj2);
        p.l(zzaf, "ResultHolder not provided.");
        ((zzo) ((zzf) obj).getService()).zzl(pendingIntent, new s(zzaf));
    }
}
