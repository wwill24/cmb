package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzit  reason: invalid package */
public final class zzit {
    private Integer zza;
    private zziu zzb;

    private zzit() {
        this.zza = null;
        throw null;
    }

    /* synthetic */ zzit(zzis zzis) {
        this.zza = null;
        this.zzb = zziu.zzc;
    }

    public final zzit zza(int i10) throws GeneralSecurityException {
        if (i10 == 32 || i10 == 48 || i10 == 64) {
            this.zza = Integer.valueOf(i10);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 32-byte, 48-byte and 64-byte AES-SIV keys are supported", new Object[]{Integer.valueOf(i10)}));
    }

    public final zzit zzb(zziu zziu) {
        this.zzb = zziu;
        return this;
    }

    public final zziw zzc() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        } else if (this.zzb != null) {
            return new zziw(num.intValue(), this.zzb, (zziv) null);
        } else {
            throw new GeneralSecurityException("Variant is not set");
        }
    }
}
