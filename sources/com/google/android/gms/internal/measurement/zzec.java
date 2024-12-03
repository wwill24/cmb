package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.p;
import pe.b;

final class zzec extends zzdu {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzbz zzb;
    final /* synthetic */ zzee zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzec(zzee zzee, Activity activity, zzbz zzbz) {
        super(zzee.zza, true);
        this.zzc = zzee;
        this.zza = activity;
        this.zzb = zzbz;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) p.k(this.zzc.zza.zzj)).onActivitySaveInstanceState(b.g(this.zza), this.zzb, this.zzi);
    }
}
