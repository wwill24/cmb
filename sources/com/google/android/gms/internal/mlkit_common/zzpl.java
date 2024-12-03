package com.google.android.gms.internal.mlkit_common;

public final /* synthetic */ class zzpl implements Runnable {
    public final /* synthetic */ zzpn zza;
    public final /* synthetic */ zzpe zzb;
    public final /* synthetic */ zzld zzc;
    public final /* synthetic */ String zzd;

    public /* synthetic */ zzpl(zzpn zzpn, zzpe zzpe, zzld zzld, String str) {
        this.zza = zzpn;
        this.zzb = zzpe;
        this.zzc = zzld;
        this.zzd = str;
    }

    public final void run() {
        this.zza.zzb(this.zzb, this.zzc, this.zzd);
    }
}
