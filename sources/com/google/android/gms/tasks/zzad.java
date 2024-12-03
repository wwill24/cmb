package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzad<T> implements zzae<T> {
    private final CountDownLatch zza = new CountDownLatch(1);

    private zzad() {
    }

    public final void onCanceled() {
        this.zza.countDown();
    }

    public final void onFailure(@NonNull Exception exc) {
        this.zza.countDown();
    }

    public final void onSuccess(T t10) {
        this.zza.countDown();
    }

    public final void zza() throws InterruptedException {
        this.zza.await();
    }

    public final boolean zzb(long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.zza.await(j10, timeUnit);
    }

    /* synthetic */ zzad(zzac zzac) {
    }
}
