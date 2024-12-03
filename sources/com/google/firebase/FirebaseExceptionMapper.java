package com.google.firebase;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.t;

public class FirebaseExceptionMapper implements t {
    @NonNull
    public final Exception getException(@NonNull Status status) {
        if (status.Y() == 8) {
            return new FirebaseException(status.zza());
        }
        return new FirebaseApiNotAvailableException(status.zza());
    }
}
