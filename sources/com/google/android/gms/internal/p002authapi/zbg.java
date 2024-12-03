package com.google.android.gms.internal.p002authapi;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.j;

/* renamed from: com.google.android.gms.internal.auth-api.zbg  reason: invalid package */
final class zbg extends zbm {
    final /* synthetic */ CredentialRequest zba;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zbg(zbl zbl, d dVar, CredentialRequest credentialRequest) {
        super(dVar);
        this.zba = credentialRequest;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ j createFailedResult(Status status) {
        return new zbe(status, (Credential) null);
    }

    /* access modifiers changed from: protected */
    public final void zba(Context context, zbt zbt) throws RemoteException {
        zbt.zbd(new zbf(this), this.zba);
    }
}
