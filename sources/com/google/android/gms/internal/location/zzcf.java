package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.internal.j;
import com.google.android.gms.tasks.OnTokenCanceledListener;

public final /* synthetic */ class zzcf implements OnTokenCanceledListener {
    public final /* synthetic */ j zza;

    public /* synthetic */ zzcf(j jVar) {
        this.zza = jVar;
    }

    public final void onCanceled() {
        j jVar = this.zza;
        int i10 = zzda.zze;
        try {
            jVar.cancel();
        } catch (RemoteException unused) {
        }
    }
}
