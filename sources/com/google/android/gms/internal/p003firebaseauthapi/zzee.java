package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzee  reason: invalid package */
public final class zzee {
    private Integer zza;
    private Integer zzb;
    private Integer zzc;
    private zzef zzd;

    private zzee() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        throw null;
    }

    /* synthetic */ zzee(zzed zzed) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzef.zzc;
    }

    public final zzee zza(int i10) throws GeneralSecurityException {
        if (i10 == 12 || i10 == 16) {
            this.zzb = Integer.valueOf(i10);
            return this;
        }
        throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", new Object[]{Integer.valueOf(i10)}));
    }

    public final zzee zzb(int i10) throws GeneralSecurityException {
        if (i10 == 16 || i10 == 24 || i10 == 32) {
            this.zza = Integer.valueOf(i10);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i10)}));
    }

    public final zzee zzc(int i10) throws GeneralSecurityException {
        this.zzc = 16;
        return this;
    }

    public final zzee zzd(zzef zzef) {
        this.zzd = zzef;
        return this;
    }

    public final zzeh zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("IV size is not set");
        } else if (this.zzd == null) {
            throw new GeneralSecurityException("Variant is not set");
        } else if (this.zzc != null) {
            int intValue = num.intValue();
            int intValue2 = this.zzb.intValue();
            this.zzc.intValue();
            return new zzeh(intValue, intValue2, 16, this.zzd, (zzeg) null);
        } else {
            throw new GeneralSecurityException("Tag size is not set");
        }
    }
}
