package com.google.android.gms.internal.p001authapiphone;

import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzs  reason: invalid package */
public final /* synthetic */ class zzs implements q {
    public final /* synthetic */ zzv zza;

    public /* synthetic */ zzs(zzv zzv) {
        this.zza = zzv;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzh) ((zzw) obj).getService()).zzf(new zzu(this.zza, (TaskCompletionSource) obj2));
    }
}
