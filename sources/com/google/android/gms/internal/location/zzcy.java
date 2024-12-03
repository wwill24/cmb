package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.i;

final class zzcy implements k.b {
    final /* synthetic */ zzcz zza;

    zzcy(zzcz zzcz) {
        this.zza = zzcz;
    }

    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        i iVar = (i) obj;
        this.zza.zza.zzb();
    }

    public final void onNotifyListenerFailed() {
    }
}
