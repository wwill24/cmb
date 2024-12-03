package com.mparticle;

import androidx.annotation.NonNull;

public interface AttributionListener {
    void onError(@NonNull AttributionError attributionError);

    void onResult(@NonNull AttributionResult attributionResult);
}
