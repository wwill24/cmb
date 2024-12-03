package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoy  reason: invalid package */
final class zzoy {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzoy(Class cls, Class cls2, zzox zzox) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzoy)) {
            return false;
        }
        zzoy zzoy = (zzoy) obj;
        if (!zzoy.zza.equals(this.zza) || !zzoy.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        Class cls = this.zzb;
        String simpleName = this.zza.getSimpleName();
        String simpleName2 = cls.getSimpleName();
        return simpleName + " with serialization type: " + simpleName2;
    }
}
