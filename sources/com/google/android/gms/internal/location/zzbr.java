package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.location.GeofencingRequest;

final class zzbr extends zzbu {
    final /* synthetic */ GeofencingRequest zza;
    final /* synthetic */ PendingIntent zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbr(zzbv zzbv, d dVar, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        super(dVar);
        this.zza = geofencingRequest;
        this.zzb = pendingIntent;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzda) bVar).zzq(this.zza, this.zzb, zzbv.zza(this));
    }
}
