package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.location.LocationRequest;

final class zzam extends zzat {
    final /* synthetic */ PendingIntent zza;
    final /* synthetic */ LocationRequest zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzam(zzau zzau, d dVar, PendingIntent pendingIntent, LocationRequest locationRequest) {
        super(dVar);
        this.zza = pendingIntent;
        this.zzb = locationRequest;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzda) bVar).zzw(this.zza, this.zzb, zzau.zza(this));
    }
}
