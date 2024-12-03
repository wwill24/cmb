package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzar  reason: invalid package */
public final class zzar {
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
