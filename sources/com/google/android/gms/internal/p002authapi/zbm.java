package com.google.android.gms.internal.p002authapi;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.j;

/* renamed from: com.google.android.gms.internal.auth-api.zbm  reason: invalid package */
abstract class zbm extends d {
    zbm(com.google.android.gms.common.api.d dVar) {
        super((a<?>) vd.a.f42079b, dVar);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        zbo zbo = (zbo) bVar;
        zba(zbo.getContext(), (zbt) zbo.getService());
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((j) obj);
    }

    /* access modifiers changed from: protected */
    public abstract void zba(Context context, zbt zbt) throws DeadObjectException, RemoteException;
}
