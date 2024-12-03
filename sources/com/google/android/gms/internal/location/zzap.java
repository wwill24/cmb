package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.location.h;

final class zzap extends zzat {
    final /* synthetic */ h zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzap(zzau zzau, d dVar, h hVar) {
        super(dVar);
        this.zza = hVar;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzda) bVar).zzB(l.c(this.zza, h.class.getSimpleName()), true, zzau.zza(this));
    }
}
