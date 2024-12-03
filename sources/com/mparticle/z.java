package com.mparticle;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public final class z implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    private final MParticle f22654a;

    public z(MParticle mParticle) {
        this.f22654a = mParticle;
    }

    public void onLocationChanged(Location location) {
        MParticle mParticle = this.f22654a;
        if (mParticle != null) {
            mParticle.setLocation(location);
        }
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i10, Bundle bundle) {
    }
}
