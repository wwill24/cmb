package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.p;

final class zzds extends zzdu {
    final /* synthetic */ Long zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ boolean zzf;
    final /* synthetic */ zzef zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzds(zzef zzef, Long l10, String str, String str2, Bundle bundle, boolean z10, boolean z11) {
        super(zzef, true);
        this.zzg = zzef;
        this.zza = l10;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bundle;
        this.zze = z10;
        this.zzf = z11;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        long j10;
        Long l10 = this.zza;
        if (l10 == null) {
            j10 = this.zzh;
        } else {
            j10 = l10.longValue();
        }
        ((zzcc) p.k(this.zzg.zzj)).logEvent(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, j10);
    }
}
