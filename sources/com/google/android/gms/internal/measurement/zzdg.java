package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.p;
import pe.b;

final class zzdg extends zzdu {
    final /* synthetic */ String zza;
    final /* synthetic */ Object zzb;
    final /* synthetic */ zzef zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdg(zzef zzef, boolean z10, int i10, String str, Object obj, Object obj2, Object obj3) {
        super(zzef, false);
        this.zzc = zzef;
        this.zza = str;
        this.zzb = obj;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) p.k(this.zzc.zzj)).logHealthData(5, this.zza, b.g(this.zzb), b.g(null), b.g(null));
    }
}
