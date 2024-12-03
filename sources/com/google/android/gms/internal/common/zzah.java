package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

@NullMarked
public final class zzah {
    static Object[] zza(Object[] objArr, int i10) {
        int i11 = 0;
        while (i11 < i10) {
            if (objArr[i11] != null) {
                i11++;
            } else {
                throw new NullPointerException("at index " + i11);
            }
        }
        return objArr;
    }
}
