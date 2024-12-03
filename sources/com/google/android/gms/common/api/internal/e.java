package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;

public interface e<R> {
    void setFailedResult(@NonNull Status status);

    void setResult(@NonNull R r10);
}
