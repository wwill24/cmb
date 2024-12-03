package com.google.android.gms.internal.mlkit_common;

import tg.b;

public final /* synthetic */ class zzpm implements Runnable {
    public final /* synthetic */ zzpn zza;
    public final /* synthetic */ zzpe zzb;
    public final /* synthetic */ zzpp zzc;
    public final /* synthetic */ b zzd;

    public /* synthetic */ zzpm(zzpn zzpn, zzpe zzpe, zzpp zzpp, b bVar) {
        this.zza = zzpn;
        this.zzb = zzpe;
        this.zzc = zzpp;
        this.zzd = bVar;
    }

    public final void run() {
        this.zza.zzc(this.zzb, this.zzc, this.zzd);
    }
}
