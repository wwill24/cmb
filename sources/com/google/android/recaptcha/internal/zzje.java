package com.google.android.recaptcha.internal;

public final class zzje extends RuntimeException {
    public zzje(zzhy zzhy) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzgy zza() {
        return new zzgy(getMessage());
    }
}
