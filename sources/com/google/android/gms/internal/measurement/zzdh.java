package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.p;

final class zzdh extends zzdu {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzbz zzb;
    final /* synthetic */ zzef zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdh(zzef zzef, Bundle bundle, zzbz zzbz) {
        super(zzef, true);
        this.zzc = zzef;
        this.zza = bundle;
        this.zzb = zzbz;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) p.k(this.zzc.zzj)).performAction(this.zza, this.zzb, this.zzh);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzb.zze((Bundle) null);
    }
}
