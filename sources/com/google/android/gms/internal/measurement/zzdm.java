package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.p;

final class zzdm extends zzdu {
    final /* synthetic */ zzbz zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzef zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdm(zzef zzef, zzbz zzbz, int i10) {
        super(zzef, true);
        this.zzc = zzef;
        this.zza = zzbz;
        this.zzb = i10;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) p.k(this.zzc.zzj)).getTestFlag(this.zza, this.zzb);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zza.zze((Bundle) null);
    }
}
