package com.appsflyer.internal;

import androidx.annotation.NonNull;

public enum AFf1xSDK {
    SUCCESS,
    FAILURE,
    NA,
    INTERNAL_ERROR;

    @NonNull
    public final String toString() {
        return super.toString().toLowerCase();
    }
}
