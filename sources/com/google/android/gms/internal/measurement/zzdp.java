package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.p;

final class zzdp extends zzdu {
    final /* synthetic */ zzdv zza;
    final /* synthetic */ zzef zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdp(zzef zzef, zzdv zzdv) {
        super(zzef, true);
        this.zzb = zzef;
        this.zza = zzdv;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) p.k(this.zzb.zzj)).setEventInterceptor(this.zza);
    }
}
