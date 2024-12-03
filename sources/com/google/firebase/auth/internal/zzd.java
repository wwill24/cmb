package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzd implements OnSuccessListener {
    final /* synthetic */ TaskCompletionSource zza;

    zzd(zzf zzf, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        this.zza.setResult(new zze((String) obj, (String) null));
    }
}
