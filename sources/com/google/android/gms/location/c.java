package com.google.android.gms.location;

import android.location.Location;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.f;

@Deprecated
public interface c {
    Location getLastLocation(@NonNull d dVar);

    @NonNull
    f<Status> removeLocationUpdates(@NonNull d dVar, @NonNull i iVar);

    @NonNull
    f<Status> requestLocationUpdates(@NonNull d dVar, @NonNull LocationRequest locationRequest, @NonNull i iVar);
}
