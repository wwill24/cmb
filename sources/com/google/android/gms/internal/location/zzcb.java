package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.j;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;

abstract class zzcb extends d {
    public zzcb(com.google.android.gms.common.api.d dVar) {
        super((a<?>) zzbp.zzb, dVar);
    }

    public final /* synthetic */ j createFailedResult(Status status) {
        return new LocationSettingsResult(status, (LocationSettingsStates) null);
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((j) obj);
    }
}
