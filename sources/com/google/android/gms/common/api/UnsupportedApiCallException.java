package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;

public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final Feature zza;

    public UnsupportedApiCallException(@NonNull Feature feature) {
        this.zza = feature;
    }

    @NonNull
    public String getMessage() {
        return "Missing ".concat(String.valueOf(this.zza));
    }
}
