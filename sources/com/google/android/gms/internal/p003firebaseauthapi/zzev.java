package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzev  reason: invalid package */
public final class zzev {
    private Integer zza;
    private Integer zzb;
    private Integer zzc;
    private zzew zzd;

    private zzev() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        throw null;
    }

    /* synthetic */ zzev(zzeu zzeu) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzew.zzc;
    }

    public final zzev zza(int i10) throws GeneralSecurityException {
        this.zzb = 12;
        return this;
    }

    public final zzev zzb(int i10) throws GeneralSecurityException {
        if (i10 == 16 || i10 == 24 || i10 == 32) {
            this.zza = Integer.valueOf(i10);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i10)}));
    }

    public final zzev zzc(int i10) throws GeneralSecurityException {
        this.zzc = 16;
        return this;
    }

    public final zzev zzd(zzew zzew) {
        this.zzd = zzew;
        return this;
    }

    public final zzey zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        } else if (this.zzd == null) {
            throw new GeneralSecurityException("Variant is not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("IV size is not set");
        } else if (this.zzc != null) {
            int intValue = num.intValue();
            this.zzb.intValue();
            this.zzc.intValue();
            return new zzey(intValue, 12, 16, this.zzd, (zzex) null);
        } else {
            throw new GeneralSecurityException("Tag size is not set");
        }
    }
}
