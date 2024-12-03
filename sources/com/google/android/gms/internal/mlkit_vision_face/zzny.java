package com.google.android.gms.internal.mlkit_vision_face;

import com.google.mlkit.vision.face.internal.f;

public final /* synthetic */ class zzny implements Runnable {
    public final /* synthetic */ zzoc zza;
    public final /* synthetic */ zzkt zzb;
    public final /* synthetic */ Object zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ f zze;

    public /* synthetic */ zzny(zzoc zzoc, zzkt zzkt, Object obj, long j10, f fVar, byte[] bArr) {
        this.zza = zzoc;
        this.zzb = zzkt;
        this.zzc = obj;
        this.zzd = j10;
        this.zze = fVar;
    }

    public final void run() {
        this.zza.zzh(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
