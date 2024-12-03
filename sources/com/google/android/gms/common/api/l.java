package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.j;

public abstract class l<R extends j> implements k<R> {
    public final void a(@NonNull R r10) {
        Status status = r10.getStatus();
        if (status.i0()) {
            c(r10);
            return;
        }
        b(status);
        if (r10 instanceof h) {
            try {
                ((h) r10).release();
            } catch (RuntimeException unused) {
                "Unable to release ".concat(String.valueOf(r10));
            }
        }
    }

    public abstract void b(@NonNull Status status);

    public abstract void c(@NonNull R r10);
}
