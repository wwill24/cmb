package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrf  reason: invalid package */
public final class zzrf implements zzpx {
    private final zzqe zza;

    public zzrf(zzqe zzqe) throws GeneralSecurityException {
        if (zzij.zza(2)) {
            this.zza = zzqe;
            return;
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
