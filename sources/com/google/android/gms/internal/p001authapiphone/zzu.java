package com.google.android.gms.internal.p001authapiphone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.h;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzu  reason: invalid package */
final class zzu extends h.a {
    final /* synthetic */ TaskCompletionSource zza;

    zzu(zzv zzv, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void onResult(Status status) {
        if (status.Y() == 6) {
            this.zza.trySetException(b.a(status));
        } else {
            w.a(status, this.zza);
        }
    }
}
