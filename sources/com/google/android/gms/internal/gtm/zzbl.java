package com.google.android.gms.internal.gtm;

final class zzbl implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzbq zzb;

    zzbl(zzbq zzbq, int i10) {
        this.zzb = zzbq;
        this.zza = i10;
    }

    public final void run() {
        this.zzb.zza.zzZ(((long) this.zza) * 1000);
    }
}
