package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.api.internal.s;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzaa implements q {
    public final /* synthetic */ ActivityTransitionRequest zza;
    public final /* synthetic */ PendingIntent zzb;

    public /* synthetic */ zzaa(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent) {
        this.zza = activityTransitionRequest;
        this.zzb = pendingIntent;
    }

    public final void accept(Object obj, Object obj2) {
        ActivityTransitionRequest activityTransitionRequest = this.zza;
        PendingIntent pendingIntent = this.zzb;
        a aVar = zzag.zzb;
        zzaf zzaf = new zzaf((TaskCompletionSource) obj2);
        p.l(activityTransitionRequest, "activityTransitionRequest must be specified.");
        p.l(pendingIntent, "PendingIntent must be specified.");
        p.l(zzaf, "ResultHolder not provided.");
        ((zzo) ((zzf) obj).getService()).zzq(activityTransitionRequest, pendingIntent, new s(zzaf));
    }
}
