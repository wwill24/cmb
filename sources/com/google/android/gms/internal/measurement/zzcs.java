package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.p;

final class zzcs extends zzdu {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzef zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcs(zzef zzef, Boolean bool) {
        super(zzef, true);
        this.zzb = zzef;
        this.zza = bool;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        if (this.zza != null) {
            ((zzcc) p.k(this.zzb.zzj)).setMeasurementEnabled(this.zza.booleanValue(), this.zzh);
        } else {
            ((zzcc) p.k(this.zzb.zzj)).clearMeasurementEnabled(this.zzh);
        }
    }
}
