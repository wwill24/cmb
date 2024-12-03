package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbo implements q, zzcs {
    final /* synthetic */ zzbp zza;
    private final zzbn zzb;
    private k zzc;
    private boolean zzd = true;

    zzbo(zzbp zzbp, k kVar, zzbn zzbn) {
        this.zza = zzbp;
        this.zzc = kVar;
        this.zzb = zzbn;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
        k.a b10;
        boolean z10;
        zzda zzda = (zzda) obj;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        synchronized (this) {
            b10 = this.zzc.b();
            z10 = this.zzd;
            this.zzc.a();
        }
        if (b10 == null) {
            taskCompletionSource.setResult(Boolean.FALSE);
        } else {
            this.zzb.zza(zzda, b10, z10, taskCompletionSource);
        }
    }

    public final synchronized k zza() {
        return this.zzc;
    }

    public final void zzb() {
        k.a b10;
        synchronized (this) {
            this.zzd = false;
            b10 = this.zzc.b();
        }
        if (b10 != null) {
            this.zza.doUnregisterEventListener(b10, 2441);
        }
    }

    public final synchronized void zzc(k kVar) {
        k kVar2 = this.zzc;
        if (kVar2 != kVar) {
            kVar2.a();
            this.zzc = kVar;
        }
    }
}
