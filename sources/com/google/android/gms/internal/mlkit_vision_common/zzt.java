package com.google.android.gms.internal.mlkit_vision_common;

public final class zzt {
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
