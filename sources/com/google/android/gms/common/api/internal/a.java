package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.b;

public class a implements t {
    @NonNull
    public final Exception getException(@NonNull Status status) {
        return b.a(status);
    }
}
