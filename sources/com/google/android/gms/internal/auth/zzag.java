package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.RemoteException;
import com.google.android.gms.auth.account.g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.j;

final class zzag extends d {
    final /* synthetic */ Account zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzag(zzal zzal, a aVar, com.google.android.gms.common.api.d dVar, Account account) {
        super((a<?>) aVar, dVar);
        this.zza = account;
    }

    /* access modifiers changed from: protected */
    public final j createFailedResult(Status status) {
        return new zzak(status);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((g) ((zzam) bVar).getService()).m0(new zzaf(this), this.zza);
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((j) obj);
    }
}
