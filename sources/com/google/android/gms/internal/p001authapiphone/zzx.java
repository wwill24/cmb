package com.google.android.gms.internal.p001authapiphone;

import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzx  reason: invalid package */
public final /* synthetic */ class zzx implements q {
    public final /* synthetic */ zzab zza;

    public /* synthetic */ zzx(zzab zzab) {
        this.zza = zzab;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzh) ((zzw) obj).getService()).zzg(new zzz(this.zza, (TaskCompletionSource) obj2));
    }
}
