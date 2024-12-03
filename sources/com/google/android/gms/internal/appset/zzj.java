package com.google.android.gms.internal.appset;

import me.i;

final class zzj implements Runnable {
    final /* synthetic */ zzl zza;

    /* synthetic */ zzj(zzl zzl, zzi zzi) {
        this.zza = zzl;
    }

    public final void run() {
        long zza2 = this.zza.zza();
        if (zza2 != -1 && i.c().currentTimeMillis() > zza2) {
            zzl.zze(this.zza.zzb);
        }
    }
}
