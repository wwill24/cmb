package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.p;

final class zzcv extends zzdu {
    final /* synthetic */ zzef zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcv(zzef zzef) {
        super(zzef, true);
        this.zza = zzef;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) p.k(this.zza.zzj)).resetAnalyticsData(this.zzh);
    }
}
