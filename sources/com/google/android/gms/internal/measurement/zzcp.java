package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.p;

final class zzcp extends zzdu {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbz zzc;
    final /* synthetic */ zzef zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcp(zzef zzef, String str, String str2, zzbz zzbz) {
        super(zzef, true);
        this.zzd = zzef;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzbz;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) p.k(this.zzd.zzj)).getConditionalUserProperties(this.zza, this.zzb, this.zzc);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzc.zze((Bundle) null);
    }
}
