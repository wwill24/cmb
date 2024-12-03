package com.google.android.gms.internal.p003firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpf  reason: invalid package */
public final class zzpf {
    private zzpr zza = null;
    private zzzq zzb = null;
    private Integer zzc = null;

    private zzpf() {
    }

    /* synthetic */ zzpf(zzpe zzpe) {
    }

    public final zzpf zza(zzzq zzzq) throws GeneralSecurityException {
        this.zzb = zzzq;
        return this;
    }

    public final zzpf zzb(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzpf zzc(zzpr zzpr) {
        this.zza = zzpr;
        return this;
    }

    public final zzph zzd() throws GeneralSecurityException {
        zzzq zzzq;
        zzzo zzb2;
        zzpr zzpr = this.zza;
        if (zzpr == null || (zzzq = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzpr.zzc() != zzzq.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzpr.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zza() || this.zzc == null) {
            if (this.zza.zze() == zzpp.zzd) {
                zzb2 = zzzo.zzb(new byte[0]);
            } else if (this.zza.zze() == zzpp.zzc || this.zza.zze() == zzpp.zzb) {
                zzb2 = zzzo.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zze() == zzpp.zza) {
                zzb2 = zzzo.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(this.zza.zze())));
            }
            return new zzph(this.zza, this.zzb, zzb2, this.zzc, (zzpg) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
