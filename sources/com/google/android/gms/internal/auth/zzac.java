package com.google.android.gms.internal.auth;

import android.os.RemoteException;
import com.google.android.gms.auth.account.g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.j;

final class zzac extends d {
    final /* synthetic */ boolean zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzac(zzal zzal, a aVar, com.google.android.gms.common.api.d dVar, boolean z10) {
        super((a<?>) aVar, dVar);
        this.zza = z10;
    }

    /* access modifiers changed from: protected */
    public final j createFailedResult(Status status) {
        return new zzaj(status);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((g) ((zzam) bVar).getService()).C(this.zza);
        setResult(new zzaj(Status.f38500g));
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((j) obj);
    }
}
