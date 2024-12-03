package com.google.android.gms.internal.p003firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeo  reason: invalid package */
public final class zzeo {
    private zzey zza = null;
    private zzzq zzb = null;
    private Integer zzc = null;

    private zzeo() {
    }

    /* synthetic */ zzeo(zzen zzen) {
    }

    public final zzeo zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzeo zzb(zzzq zzzq) {
        this.zzb = zzzq;
        return this;
    }

    public final zzeo zzc(zzey zzey) {
        this.zza = zzey;
        return this;
    }

    public final zzeq zzd() throws GeneralSecurityException {
        zzzq zzzq;
        zzzo zzb2;
        zzey zzey = this.zza;
        if (zzey == null || (zzzq = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzey.zzb() != zzzq.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzey.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zza() || this.zzc == null) {
            if (this.zza.zzd() == zzew.zzc) {
                zzb2 = zzzo.zzb(new byte[0]);
            } else if (this.zza.zzd() == zzew.zzb) {
                zzb2 = zzzo.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzd() == zzew.zza) {
                zzb2 = zzzo.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: ".concat(String.valueOf(this.zza.zzd())));
            }
            return new zzeq(this.zza, this.zzb, zzb2, this.zzc, (zzep) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
