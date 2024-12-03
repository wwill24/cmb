package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import java.util.List;

final class zzbt extends zzbu {
    final /* synthetic */ List zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbt(zzbv zzbv, d dVar, List list) {
        super(dVar);
        this.zza = list;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzda) bVar).zzy(this.zza, zzbv.zza(this));
    }
}
