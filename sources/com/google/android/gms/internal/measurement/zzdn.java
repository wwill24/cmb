package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.p;

final class zzdn extends zzdu {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzef zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdn(zzef zzef, boolean z10) {
        super(zzef, true);
        this.zzb = zzef;
        this.zza = z10;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) p.k(this.zzb.zzj)).setDataCollectionEnabled(this.zza);
    }
}
