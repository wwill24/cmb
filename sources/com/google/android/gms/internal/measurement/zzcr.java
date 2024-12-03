package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.p;
import pe.b;

final class zzcr extends zzdu {
    final /* synthetic */ Activity zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzef zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcr(zzef zzef, Activity activity, String str, String str2) {
        super(zzef, true);
        this.zzd = zzef;
        this.zza = activity;
        this.zzb = str;
        this.zzc = str2;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) p.k(this.zzd.zzj)).setCurrentScreen(b.g(this.zza), this.zzb, this.zzc, this.zzh);
    }
}
