package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

final class zzj implements zzq {
    private final Executor zza;
    /* access modifiers changed from: private */
    public final Object zzb = new Object();
    /* access modifiers changed from: private */
    public OnCompleteListener zzc;

    public zzj(@NonNull Executor executor, @NonNull OnCompleteListener onCompleteListener) {
        this.zza = executor;
        this.zzc = onCompleteListener;
    }

    public final void zzc() {
        synchronized (this.zzb) {
            this.zzc = null;
        }
    }

    public final void zzd(@NonNull Task task) {
        synchronized (this.zzb) {
            if (this.zzc != null) {
                this.zza.execute(new zzi(this, task));
            }
        }
    }
}
