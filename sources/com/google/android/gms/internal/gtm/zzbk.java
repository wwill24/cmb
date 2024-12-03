package com.google.android.gms.internal.gtm;

final class zzbk implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ Runnable zzb;
    final /* synthetic */ zzbq zzc;

    zzbk(zzbq zzbq, String str, Runnable runnable) {
        this.zzc = zzbq;
        this.zza = str;
        this.zzb = runnable;
    }

    public final void run() {
        this.zzc.zza.zzn(this.zza);
        this.zzb.run();
    }
}
