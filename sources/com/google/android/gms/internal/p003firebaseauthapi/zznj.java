package com.google.android.gms.internal.p003firebaseauthapi;

import com.mparticle.identity.IdentityHttpResponse;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznj  reason: invalid package */
public final class zznj extends zzce {
    private final zzop zza;

    public zznj(zzop zzop) {
        this.zza = zzop;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zznj)) {
            return false;
        }
        zzop zzop = ((zznj) obj).zza;
        if (!this.zza.zzc().zze().equals(zzop.zzc().zze()) || !this.zza.zzc().zzg().equals(zzop.zzc().zzg()) || !this.zza.zzc().zzf().equals(zzop.zzc().zzf())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        zzop zzop = this.zza;
        return Arrays.hashCode(new Object[]{zzop.zzc(), zzop.zzd()});
    }

    public final String toString() {
        String str;
        Object[] objArr = new Object[2];
        objArr[0] = this.zza.zzc().zzg();
        zzxo zze = this.zza.zzc().zze();
        zzxo zzxo = zzxo.UNKNOWN_PREFIX;
        int ordinal = zze.ordinal();
        if (ordinal == 1) {
            str = "TINK";
        } else if (ordinal == 2) {
            str = "LEGACY";
        } else if (ordinal == 3) {
            str = "RAW";
        } else if (ordinal != 4) {
            str = IdentityHttpResponse.UNKNOWN;
        } else {
            str = "CRUNCHY";
        }
        objArr[1] = str;
        return String.format("(typeUrl=%s, outputPrefixType=%s)", objArr);
    }

    public final boolean zza() {
        throw null;
    }

    public final zzop zzb() {
        return this.zza;
    }
}
