package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.p;

final class zzco extends zzdu {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Bundle zzc;
    final /* synthetic */ zzef zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzco(zzef zzef, String str, String str2, Bundle bundle) {
        super(zzef, true);
        this.zzd = zzef;
        this.zza = str;
        this.zzb = str2;
        this.zzc = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) p.k(this.zzd.zzj)).clearConditionalUserProperty(this.zza, this.zzb, this.zzc);
    }
}
