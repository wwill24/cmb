package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfm  reason: invalid package */
public final class zzfm {
    private Integer zza;
    private zzfn zzb;

    private zzfm() {
        this.zza = null;
        throw null;
    }

    /* synthetic */ zzfm(zzfl zzfl) {
        this.zza = null;
        this.zzb = zzfn.zzc;
    }

    public final zzfm zza(int i10) throws GeneralSecurityException {
        if (i10 == 16 || i10 == 32) {
            this.zza = Integer.valueOf(i10);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i10)}));
    }

    public final zzfm zzb(zzfn zzfn) {
        this.zzb = zzfn;
        return this;
    }

    public final zzfp zzc() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        } else if (this.zzb != null) {
            return new zzfp(num.intValue(), this.zzb, (zzfo) null);
        } else {
            throw new GeneralSecurityException("Variant is not set");
        }
    }
}
