package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.p;

final class zzdr extends zzdu {
    final /* synthetic */ zzdw zza;
    final /* synthetic */ zzef zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdr(zzef zzef, zzdw zzdw) {
        super(zzef, true);
        this.zzb = zzef;
        this.zza = zzdw;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) p.k(this.zzb.zzj)).unregisterOnMeasurementEventListener(this.zza);
    }
}
