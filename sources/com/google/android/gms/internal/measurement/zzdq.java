package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.p;

final class zzdq extends zzdu {
    final /* synthetic */ zzdw zza;
    final /* synthetic */ zzef zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdq(zzef zzef, zzdw zzdw) {
        super(zzef, true);
        this.zzb = zzef;
        this.zza = zzdw;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) p.k(this.zzb.zzj)).registerOnMeasurementEventListener(this.zza);
    }
}
