package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.mlkit.vision.text.internal.m;

public final /* synthetic */ class zzod implements Runnable {
    public final /* synthetic */ zzog zza;
    public final /* synthetic */ zzkt zzb;
    public final /* synthetic */ m zzc;

    public /* synthetic */ zzod(zzog zzog, zzkt zzkt, m mVar, byte[] bArr) {
        this.zza = zzog;
        this.zzb = zzkt;
        this.zzc = mVar;
    }

    public final void run() {
        this.zza.zzg(this.zzb, this.zzc);
    }
}
