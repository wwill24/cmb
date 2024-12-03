package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.p;
import pe.b;

final class zzdt extends zzdu {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzef zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdt(zzef zzef, String str, String str2, Object obj, boolean z10) {
        super(zzef, true);
        this.zze = zzef;
        this.zza = str;
        this.zzb = str2;
        this.zzc = obj;
        this.zzd = z10;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) p.k(this.zze.zzj)).setUserProperty(this.zza, this.zzb, b.g(this.zzc), this.zzd, this.zzh);
    }
}
