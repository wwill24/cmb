package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.j;

public class u extends BasePendingResult<Status> {
    public u(@NonNull d dVar) {
        super(dVar);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final /* bridge */ /* synthetic */ j createFailedResult(@NonNull Status status) {
        return status;
    }
}
