package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.LocationRequest;

final class zzal extends zzat {
    final /* synthetic */ k zza;
    final /* synthetic */ LocationRequest zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzal(zzau zzau, d dVar, k kVar, LocationRequest locationRequest) {
        super(dVar);
        this.zza = kVar;
        this.zzb = locationRequest;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzda) bVar).zzu(new zzas(this.zza), this.zzb, zzau.zza(this));
    }
}
