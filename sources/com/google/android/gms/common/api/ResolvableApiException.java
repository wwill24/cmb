package com.google.android.gms.common.api;

import androidx.annotation.NonNull;

public class ResolvableApiException extends ApiException {
    public ResolvableApiException(@NonNull Status status) {
        super(status);
    }
}
