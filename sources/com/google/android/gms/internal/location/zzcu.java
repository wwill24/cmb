package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.h;

final class zzcu implements k.b {
    final /* synthetic */ LocationAvailability zza;

    zzcu(zzcw zzcw, LocationAvailability locationAvailability) {
        this.zza = locationAvailability;
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        ((h) obj).onLocationAvailability(this.zza);
    }

    public final void onNotifyListenerFailed() {
    }
}
