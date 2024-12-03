package com.google.android.recaptcha.internal;

import java.io.IOException;

public final class zzfi extends IOException {
    zzfi() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    zzfi(String str, Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th2);
    }

    zzfi(Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
    }
}
