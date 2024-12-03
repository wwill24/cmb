package com.google.android.gms.internal.gtm;

import android.content.ComponentName;

final class zzca implements Runnable {
    final /* synthetic */ ComponentName zza;
    final /* synthetic */ zzcb zzb;

    zzca(zzcb zzcb, ComponentName componentName) {
        this.zzb = zzcb;
        this.zza = componentName;
    }

    public final void run() {
        zzcc.zzb(this.zzb.zza, this.zza);
    }
}
