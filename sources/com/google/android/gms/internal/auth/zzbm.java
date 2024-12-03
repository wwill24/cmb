package com.google.android.gms.internal.auth;

import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbm extends zzbd {
    final /* synthetic */ TaskCompletionSource zza;

    zzbm(zzbo zzbo, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(ProxyResponse proxyResponse) throws RemoteException {
        w.b(new Status(proxyResponse.f38363a), proxyResponse, this.zza);
    }
}
