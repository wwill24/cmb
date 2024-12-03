package com.google.android.gms.internal.p003firebaseauthapi;

import java.math.BigInteger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmp  reason: invalid package */
final class zzmp {
    static final zzmp zza;
    final BigInteger zzb;
    final BigInteger zzc;
    final BigInteger zzd;

    static {
        BigInteger bigInteger = BigInteger.ONE;
        zza = new zzmp(bigInteger, bigInteger, BigInteger.ZERO);
    }

    zzmp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.zzb = bigInteger;
        this.zzc = bigInteger2;
        this.zzd = bigInteger3;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza() {
        return this.zzd.equals(BigInteger.ZERO);
    }
}
