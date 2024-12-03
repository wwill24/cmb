package com.google.android.gms.internal.play_billing;

import java.io.IOException;

public final class zzbg extends IOException {
    zzbg() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    zzbg(String str, Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th2);
    }

    zzbg(Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
    }
}
