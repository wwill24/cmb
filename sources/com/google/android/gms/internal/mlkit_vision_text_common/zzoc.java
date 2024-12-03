package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.mlkit.vision.text.internal.m;

public final /* synthetic */ class zzoc implements Runnable {
    public final /* synthetic */ zzog zza;
    public final /* synthetic */ zzkt zzb;
    public final /* synthetic */ Object zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ m zze;

    public /* synthetic */ zzoc(zzog zzog, zzkt zzkt, Object obj, long j10, m mVar, byte[] bArr) {
        this.zza = zzog;
        this.zzb = zzkt;
        this.zzc = obj;
        this.zzd = j10;
        this.zze = mVar;
    }

    public final void run() {
        this.zza.zzh(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
