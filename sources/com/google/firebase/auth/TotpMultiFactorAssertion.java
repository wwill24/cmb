package com.google.firebase.auth;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;

public class TotpMultiFactorAssertion extends MultiFactorAssertion {
    private final String zza;
    private final TotpSecret zzb;
    private final String zzc;

    public TotpMultiFactorAssertion(@NonNull String str, TotpSecret totpSecret, String str2) {
        this.zza = p.g(str);
        this.zzb = totpSecret;
        this.zzc = str2;
    }

    @NonNull
    public String getFactorId() {
        return TotpMultiFactorGenerator.FACTOR_ID;
    }

    public final TotpSecret zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zzc;
    }

    @NonNull
    public final String zzc() {
        return this.zza;
    }
}
