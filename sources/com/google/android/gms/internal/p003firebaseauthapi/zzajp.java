package com.google.android.gms.internal.p003firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajp  reason: invalid package */
public final class zzajp extends IOException {
    zzajp() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    zzajp(String str, Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th2);
    }

    zzajp(Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
    }
}
