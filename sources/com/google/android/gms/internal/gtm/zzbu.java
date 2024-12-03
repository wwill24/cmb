package com.google.android.gms.internal.gtm;

import java.lang.Thread;

final class zzbu implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ zzbv zza;

    zzbu(zzbv zzbv) {
        this.zza = zzbv;
    }

    public final void uncaughtException(Thread thread, Throwable th2) {
        zzfb zzn = this.zza.zzn();
        if (zzn != null) {
            zzn.zzK("Job execution failed", th2);
        }
    }
}
