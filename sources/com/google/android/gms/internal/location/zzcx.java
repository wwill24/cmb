package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.i;

final class zzcx implements k.b {
    final /* synthetic */ Location zza;

    zzcx(zzcz zzcz, Location location) {
        this.zza = location;
    }

    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((i) obj).onLocationChanged(this.zza);
    }

    public final void onNotifyListenerFailed() {
    }
}
