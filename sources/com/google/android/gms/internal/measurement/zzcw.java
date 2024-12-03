package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.p;

final class zzcw extends zzdu {
    final /* synthetic */ long zza;
    final /* synthetic */ zzef zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcw(zzef zzef, long j10) {
        super(zzef, true);
        this.zzb = zzef;
        this.zza = j10;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) p.k(this.zzb.zzj)).setSessionTimeoutDuration(this.zza);
    }
}
