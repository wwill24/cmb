package com.google.android.gms.internal.p002authapi;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.j;

/* renamed from: com.google.android.gms.internal.auth-api.zbj  reason: invalid package */
final class zbj extends zbm {
    zbj(zbl zbl, d dVar) {
        super(dVar);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ j createFailedResult(Status status) {
        return status;
    }

    /* access modifiers changed from: protected */
    public final void zba(Context context, zbt zbt) throws RemoteException {
        zbt.zbf(new zbk(this));
    }
}
