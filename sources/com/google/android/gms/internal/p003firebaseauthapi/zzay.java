package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzay  reason: invalid package */
public final class zzay {
    static int zza(Set set) {
        int i10;
        int i11 = 0;
        for (Object next : set) {
            if (next != null) {
                i10 = next.hashCode();
            } else {
                i10 = 0;
            }
            i11 += i10;
        }
        return i11;
    }
}
