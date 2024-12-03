package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.f;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.l;

public final class zzcc implements l {
    public final f<LocationSettingsResult> checkLocationSettings(d dVar, LocationSettingsRequest locationSettingsRequest) {
        return dVar.g(new zzca(this, dVar, locationSettingsRequest, (String) null));
    }
}
