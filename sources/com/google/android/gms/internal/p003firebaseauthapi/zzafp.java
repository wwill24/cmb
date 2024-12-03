package com.google.android.gms.internal.p003firebaseauthapi;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafp  reason: invalid package */
final class zzafp implements OnFailureListener {
    zzafp(zzaft zzaft) {
    }

    public final void onFailure(@NonNull Exception exc) {
        zzaft.zza.c("SmsRetrieverClient failed to start: ".concat(String.valueOf(exc.getMessage())), new Object[0]);
    }
}
