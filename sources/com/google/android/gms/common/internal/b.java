package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

public class b {
    @NonNull
    public static ApiException a(@NonNull Status status) {
        if (status.f0()) {
            return new ResolvableApiException(status);
        }
        return new ApiException(status);
    }
}
