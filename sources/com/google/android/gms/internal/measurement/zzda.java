package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.p;

final class zzda extends zzdu {
    final /* synthetic */ zzbz zza;
    final /* synthetic */ zzef zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzda(zzef zzef, zzbz zzbz) {
        super(zzef, true);
        this.zzb = zzef;
        this.zza = zzbz;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) p.k(this.zzb.zzj)).getGmpAppId(this.zza);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zza.zze((Bundle) null);
    }
}
