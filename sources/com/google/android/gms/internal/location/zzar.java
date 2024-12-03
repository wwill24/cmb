package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;

final class zzar extends zzat {
    final /* synthetic */ Location zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzar(zzau zzau, d dVar, Location location) {
        super(dVar);
        this.zza = location;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzda) bVar).zzz(this.zza, zzau.zza(this));
    }
}
