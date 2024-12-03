package com.google.firebase.auth.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzc implements OnFailureListener {
    final /* synthetic */ TaskCompletionSource zza;

    zzc(zzf zzf, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void onFailure(@NonNull Exception exc) {
        String unused = zzf.zza;
        String.format("Failed to get reCAPTCHA token with error [%s]- calling backend without app verification", new Object[]{exc.getMessage()});
        this.zza.setResult(new zze((String) null, (String) null));
    }
}
