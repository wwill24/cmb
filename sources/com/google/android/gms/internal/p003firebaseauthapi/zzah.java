package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.api.a;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzah  reason: invalid package */
public class zzah {
    zzah() {
    }

    static int zza(int i10, int i11) {
        if (i11 >= 0) {
            int i12 = i10 + (i10 >> 1) + 1;
            if (i12 < i11) {
                int highestOneBit = Integer.highestOneBit(i11 - 1);
                i12 = highestOneBit + highestOneBit;
            }
            if (i12 < 0) {
                return a.e.API_PRIORITY_OTHER;
            }
            return i12;
        }
        throw new AssertionError("cannot store more than MAX_VALUE elements");
    }
}
