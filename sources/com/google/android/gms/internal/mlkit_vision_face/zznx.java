package com.google.android.gms.internal.mlkit_vision_face;

public final /* synthetic */ class zznx implements Runnable {
    public final /* synthetic */ zzoc zza;
    public final /* synthetic */ zznr zzb;
    public final /* synthetic */ zzkt zzc;
    public final /* synthetic */ String zzd;

    public /* synthetic */ zznx(zzoc zzoc, zznr zznr, zzkt zzkt, String str) {
        this.zza = zzoc;
        this.zzb = zznr;
        this.zzc = zzkt;
        this.zzd = str;
    }

    public final void run() {
        this.zza.zzc(this.zzb, this.zzc, this.zzd);
    }
}
