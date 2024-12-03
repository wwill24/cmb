package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

final class zzn implements zzq {
    private final Executor zza;
    /* access modifiers changed from: private */
    public final Object zzb = new Object();
    /* access modifiers changed from: private */
    public OnSuccessListener zzc;

    public zzn(@NonNull Executor executor, @NonNull OnSuccessListener onSuccessListener) {
        this.zza = executor;
        this.zzc = onSuccessListener;
    }

    public final void zzc() {
        synchronized (this.zzb) {
            this.zzc = null;
        }
    }

    public final void zzd(@NonNull Task task) {
        if (task.isSuccessful()) {
            synchronized (this.zzb) {
                if (this.zzc != null) {
                    this.zza.execute(new zzm(this, task));
                }
            }
        }
    }
}
