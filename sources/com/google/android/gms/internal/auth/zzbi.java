package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.j;
import vd.b;

abstract class zzbi extends d {
    public zzbi(com.google.android.gms.common.api.d dVar) {
        super((a<?>) b.f42094a, dVar);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ j createFailedResult(Status status) {
        return new zzbu(status);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        zzbe zzbe = (zzbe) bVar;
        zza(zzbe.getContext(), (zzbh) zzbe.getService());
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((j) obj);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(Context context, zzbh zzbh) throws RemoteException;
}
