package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.p;

final class zzt extends zzv {
    final /* synthetic */ long zza;
    final /* synthetic */ PendingIntent zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzt(zzw zzw, d dVar, long j10, PendingIntent pendingIntent) {
        super(dVar);
        this.zza = j10;
        this.zzb = pendingIntent;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        boolean z10;
        zzf zzf = (zzf) bVar;
        long j10 = this.zza;
        PendingIntent pendingIntent = this.zzb;
        p.k(pendingIntent);
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.b(z10, "detectionIntervalMillis must be >= 0");
        ((zzo) zzf.getService()).zzr(j10, true, pendingIntent);
        setResult(Status.f38500g);
    }
}
