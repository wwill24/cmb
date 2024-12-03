package com.google.android.gms.internal.mlkit_vision_text_common;

public final /* synthetic */ class zzob implements Runnable {
    public final /* synthetic */ zzog zza;
    public final /* synthetic */ zznv zzb;
    public final /* synthetic */ zzkt zzc;
    public final /* synthetic */ String zzd;

    public /* synthetic */ zzob(zzog zzog, zznv zznv, zzkt zzkt, String str) {
        this.zza = zzog;
        this.zzb = zznv;
        this.zzc = zzkt;
        this.zzd = str;
    }

    public final void run() {
        this.zza.zzc(this.zzb, this.zzc, this.zzd);
    }
}
