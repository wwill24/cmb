package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.d;

final class zzbq extends zzbi {
    final /* synthetic */ ProxyRequest zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbq(zzbt zzbt, d dVar, ProxyRequest proxyRequest) {
        super(dVar);
        this.zza = proxyRequest;
    }

    /* access modifiers changed from: protected */
    public final void zza(Context context, zzbh zzbh) throws RemoteException {
        zzbh.zze(new zzbp(this), this.zza);
    }
}
