package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrv  reason: invalid package */
public final class zzrv {
    private final zzro zza;
    private final List zzb;
    private final Integer zzc;

    /* synthetic */ zzrv(zzro zzro, List list, Integer num, zzru zzru) {
        this.zza = zzro;
        this.zzb = list;
        this.zzc = num;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzrv)) {
            return false;
        }
        zzrv zzrv = (zzrv) obj;
        if (this.zza.equals(zzrv.zza) && this.zzb.equals(zzrv.zzb)) {
            Integer num = this.zzc;
            Integer num2 = zzrv.zzc;
            if (num == num2) {
                return true;
            }
            if (num == null || !num.equals(num2)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", new Object[]{this.zza, this.zzb, this.zzc});
    }
}
