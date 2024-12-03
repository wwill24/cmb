package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

abstract class zzdu implements Runnable {
    final long zzh;
    final long zzi;
    final boolean zzj;
    final /* synthetic */ zzef zzk;

    zzdu(zzef zzef, boolean z10) {
        this.zzk = zzef;
        this.zzh = zzef.zza.currentTimeMillis();
        this.zzi = zzef.zza.b();
        this.zzj = z10;
    }

    public final void run() {
        if (this.zzk.zzh) {
            zzb();
            return;
        }
        try {
            zza();
        } catch (Exception e10) {
            this.zzk.zzT(e10, false, this.zzj);
            zzb();
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void zza() throws RemoteException;

    /* access modifiers changed from: protected */
    public void zzb() {
    }
}
