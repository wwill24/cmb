package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzch implements OnTokenCanceledListener {
    public final /* synthetic */ zzda zza;
    public final /* synthetic */ k.a zzb;

    public /* synthetic */ zzch(zzda zzda, k.a aVar) {
        this.zza = zzda;
        this.zzb = aVar;
    }

    public final void onCanceled() {
        try {
            this.zza.zzB(this.zzb, true, new TaskCompletionSource());
        } catch (RemoteException unused) {
        }
    }
}
