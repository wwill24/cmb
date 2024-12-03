package com.google.android.gms.location;

import android.location.Location;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;

public interface d {
    @NonNull
    Task<Location> getLastLocation();

    @NonNull
    Task<Void> removeLocationUpdates(@NonNull h hVar);

    @NonNull
    Task<Void> requestLocationUpdates(@NonNull LocationRequest locationRequest, @NonNull h hVar, Looper looper);
}
