package com.google.android.gms.internal.p002authapi;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.j;

/* renamed from: com.google.android.gms.internal.auth-api.zbh  reason: invalid package */
final class zbh extends zbm {
    final /* synthetic */ Credential zba;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zbh(zbl zbl, d dVar, Credential credential) {
        super(dVar);
        this.zba = credential;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ j createFailedResult(Status status) {
        return status;
    }

    /* access modifiers changed from: protected */
    public final void zba(Context context, zbt zbt) throws RemoteException {
        zbt.zbe(new zbk(this), new zbu(this.zba));
    }
}
