package com.google.android.gms.internal.p001authapiphone;

import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzm  reason: invalid package */
public final /* synthetic */ class zzm implements q {
    public final /* synthetic */ zzr zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzm(zzr zzr, String str) {
        this.zza = zzr;
        this.zzb = str;
    }

    public final void accept(Object obj, Object obj2) {
        zzr zzr = this.zza;
        ((zzh) ((zzw) obj).getService()).zzd(this.zzb, new zzq(zzr, (TaskCompletionSource) obj2));
    }
}
