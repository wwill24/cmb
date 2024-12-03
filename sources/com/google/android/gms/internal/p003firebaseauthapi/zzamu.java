package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamu  reason: invalid package */
public final class zzamu extends RuntimeException {
    public zzamu(zzalp zzalp) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzaks zza() {
        return new zzaks(getMessage());
    }
}
