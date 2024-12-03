package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.location.i;

final class zzan extends zzat {
    final /* synthetic */ i zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzan(zzau zzau, d dVar, i iVar) {
        super(dVar);
        this.zza = iVar;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzda) bVar).zzC(l.c(this.zza, i.class.getSimpleName()), true, zzau.zza(this));
    }
}
