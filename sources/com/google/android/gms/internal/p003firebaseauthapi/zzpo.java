package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpo  reason: invalid package */
public final class zzpo {
    private Integer zza;
    private Integer zzb;
    private zzpp zzc;

    private zzpo() {
        this.zza = null;
        this.zzb = null;
        throw null;
    }

    /* synthetic */ zzpo(zzpn zzpn) {
        this.zza = null;
        this.zzb = null;
        this.zzc = zzpp.zzd;
    }

    public final zzpo zza(int i10) throws GeneralSecurityException {
        if (i10 == 16 || i10 == 32) {
            this.zza = Integer.valueOf(i10);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", new Object[]{Integer.valueOf(i10 * 8)}));
    }

    public final zzpo zzb(int i10) throws GeneralSecurityException {
        if (i10 < 10 || i10 > 16) {
            throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i10);
        }
        this.zzb = Integer.valueOf(i10);
        return this;
    }

    public final zzpo zzc(zzpp zzpp) {
        this.zzc = zzpp;
        return this;
    }

    public final zzpr zzd() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("key size not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("tag size not set");
        } else if (this.zzc != null) {
            return new zzpr(num.intValue(), this.zzb.intValue(), this.zzc, (zzpq) null);
        } else {
            throw new GeneralSecurityException("variant not set");
        }
    }
}
