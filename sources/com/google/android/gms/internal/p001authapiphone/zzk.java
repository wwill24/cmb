package com.google.android.gms.internal.p001authapiphone;

import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzk  reason: invalid package */
public final /* synthetic */ class zzk implements q {
    public final /* synthetic */ zzr zza;

    public /* synthetic */ zzk(zzr zzr) {
        this.zza = zzr;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzh) ((zzw) obj).getService()).zzc(new zzp(this.zza, (TaskCompletionSource) obj2));
    }
}
