package com.google.android.recaptcha.internal;

final class zzef {
    static void zza(boolean z10, String str, long j10, long j11) {
        if (!z10) {
            throw new ArithmeticException("overflow: " + str + "(" + j10 + ", " + j11 + ")");
        }
    }

    static void zzb(boolean z10) {
        if (!z10) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
