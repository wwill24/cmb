package com.google.android.gms.internal.p001authapiphone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzq  reason: invalid package */
final class zzq extends zzf {
    final /* synthetic */ TaskCompletionSource zza;

    zzq(zzr zzr, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(Status status, boolean z10) {
        w.b(status, Boolean.valueOf(z10), this.zza);
    }
}
