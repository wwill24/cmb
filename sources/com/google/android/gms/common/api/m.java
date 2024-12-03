package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.j;

public abstract class m<R extends j, S extends j> {
    @NonNull
    public Status a(@NonNull Status status) {
        return status;
    }

    public abstract f<S> b(@NonNull R r10);
}
