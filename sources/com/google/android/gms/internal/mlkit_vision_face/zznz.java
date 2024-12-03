package com.google.android.gms.internal.mlkit_vision_face;

import com.google.mlkit.vision.face.internal.f;

public final /* synthetic */ class zznz implements Runnable {
    public final /* synthetic */ zzoc zza;
    public final /* synthetic */ zzkt zzb;
    public final /* synthetic */ f zzc;

    public /* synthetic */ zznz(zzoc zzoc, zzkt zzkt, f fVar, byte[] bArr) {
        this.zza = zzoc;
        this.zzb = zzkt;
        this.zzc = fVar;
    }

    public final void run() {
        this.zza.zzg(this.zzb, this.zzc);
    }
}
