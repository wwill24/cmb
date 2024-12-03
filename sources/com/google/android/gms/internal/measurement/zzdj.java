package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.p;

final class zzdj extends zzdu {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbz zzb;
    final /* synthetic */ zzef zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdj(zzef zzef, String str, zzbz zzbz) {
        super(zzef, true);
        this.zzc = zzef;
        this.zza = str;
        this.zzb = zzbz;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) p.k(this.zzc.zzj)).getMaxUserProperties(this.zza, this.zzb);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzb.zze((Bundle) null);
    }
}
