package com.google.android.gms.internal.p003firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzim  reason: invalid package */
public final class zzim {
    private zziw zza = null;
    private zzzq zzb = null;
    private Integer zzc = null;

    private zzim() {
    }

    /* synthetic */ zzim(zzil zzil) {
    }

    public final zzim zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzim zzb(zzzq zzzq) {
        this.zzb = zzzq;
        return this;
    }

    public final zzim zzc(zziw zziw) {
        this.zza = zziw;
        return this;
    }

    public final zzio zzd() throws GeneralSecurityException {
        zzzq zzzq;
        zzzo zzb2;
        zziw zziw = this.zza;
        if (zziw == null || (zzzq = this.zzb) == null) {
            throw new IllegalArgumentException("Cannot build without parameters and/or key material");
        } else if (zziw.zzb() != zzzq.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zziw.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zza() || this.zzc == null) {
            if (this.zza.zzd() == zziu.zzc) {
                zzb2 = zzzo.zzb(new byte[0]);
            } else if (this.zza.zzd() == zziu.zzb) {
                zzb2 = zzzo.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzd() == zziu.zza) {
                zzb2 = zzzo.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesSivParameters.Variant: ".concat(String.valueOf(this.zza.zzd())));
            }
            return new zzio(this.zza, this.zzb, zzb2, this.zzc, (zzin) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
