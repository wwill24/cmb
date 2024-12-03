package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.h;

final class zzct implements k.b {
    final /* synthetic */ LocationResult zza;

    zzct(zzcw zzcw, LocationResult locationResult) {
        this.zza = locationResult;
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        ((h) obj).onLocationResult(this.zza);
    }

    public final void onNotifyListenerFailed() {
    }
}
