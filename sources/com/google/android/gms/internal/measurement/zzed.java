package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.p;
import pe.b;

final class zzed extends zzdu {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzee zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzed(zzee zzee, Activity activity) {
        super(zzee.zza, true);
        this.zzb = zzee;
        this.zza = activity;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) p.k(this.zzb.zza.zzj)).onActivityDestroyed(b.g(this.zza), this.zzi);
    }
}
