package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzro  reason: invalid package */
public final class zzro {
    public static final zzro zza = new zzrm().zza();
    private final Map zzb;

    /* synthetic */ zzro(Map map, zzrn zzrn) {
        this.zzb = map;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzro)) {
            return false;
        }
        return this.zzb.equals(((zzro) obj).zzb);
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        return this.zzb.toString();
    }

    public final Map zza() {
        return this.zzb;
    }
}
