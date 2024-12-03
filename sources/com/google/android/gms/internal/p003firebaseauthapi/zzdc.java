package com.google.android.gms.internal.p003firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdc  reason: invalid package */
public final class zzdc {
    private zzdn zza = null;
    private zzzq zzb = null;
    private zzzq zzc = null;
    private Integer zzd = null;

    private zzdc() {
    }

    /* synthetic */ zzdc(zzdb zzdb) {
    }

    public final zzdc zza(zzzq zzzq) {
        this.zzb = zzzq;
        return this;
    }

    public final zzdc zzb(zzzq zzzq) {
        this.zzc = zzzq;
        return this;
    }

    public final zzdc zzc(Integer num) {
        this.zzd = num;
        return this;
    }

    public final zzdc zzd(zzdn zzdn) {
        this.zza = zzdn;
        return this;
    }

    public final zzde zze() throws GeneralSecurityException {
        zzzo zzb2;
        zzdn zzdn = this.zza;
        if (zzdn != null) {
            zzzq zzzq = this.zzb;
            if (zzzq == null || this.zzc == null) {
                throw new GeneralSecurityException("Cannot build without key material");
            } else if (zzdn.zzb() != zzzq.zza()) {
                throw new GeneralSecurityException("AES key size mismatch");
            } else if (zzdn.zzc() != this.zzc.zza()) {
                throw new GeneralSecurityException("HMAC key size mismatch");
            } else if (this.zza.zza() && this.zzd == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zza() || this.zzd == null) {
                if (this.zza.zzh() == zzdl.zzc) {
                    zzb2 = zzzo.zzb(new byte[0]);
                } else if (this.zza.zzh() == zzdl.zzb) {
                    zzb2 = zzzo.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzd.intValue()).array());
                } else if (this.zza.zzh() == zzdl.zza) {
                    zzb2 = zzzo.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzd.intValue()).array());
                } else {
                    throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: ".concat(String.valueOf(this.zza.zzh())));
                }
                return new zzde(this.zza, this.zzb, this.zzc, zzb2, this.zzd, (zzdd) null);
            } else {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
        } else {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
    }
}
