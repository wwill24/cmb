package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.p;

final class zzdf extends zzdu {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zzbz zzd;
    final /* synthetic */ zzef zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdf(zzef zzef, String str, String str2, boolean z10, zzbz zzbz) {
        super(zzef, true);
        this.zze = zzef;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z10;
        this.zzd = zzbz;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) p.k(this.zze.zzj)).getUserProperties(this.zza, this.zzb, this.zzc, this.zzd);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzd.zze((Bundle) null);
    }
}
