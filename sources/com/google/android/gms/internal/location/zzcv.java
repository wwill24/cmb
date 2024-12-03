package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.h;

final class zzcv implements k.b {
    final /* synthetic */ zzcw zza;

    zzcv(zzcw zzcw) {
        this.zza = zzcw;
    }

    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        h hVar = (h) obj;
        this.zza.zza.zzb();
    }

    public final void onNotifyListenerFailed() {
    }
}
