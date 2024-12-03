package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzre  reason: invalid package */
public final class zzre implements zzpx {
    private final zzph zza;

    public zzre(zzph zzph) throws GeneralSecurityException {
        if (zzij.zza(1)) {
            this.zza = zzph;
            return;
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }
}
