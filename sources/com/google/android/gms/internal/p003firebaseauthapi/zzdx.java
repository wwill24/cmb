package com.google.android.gms.internal.p003firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdx  reason: invalid package */
public final class zzdx {
    private zzeh zza = null;
    private zzzq zzb = null;
    private Integer zzc = null;

    private zzdx() {
    }

    /* synthetic */ zzdx(zzdw zzdw) {
    }

    public final zzdx zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzdx zzb(zzzq zzzq) {
        this.zzb = zzzq;
        return this;
    }

    public final zzdx zzc(zzeh zzeh) {
        this.zza = zzeh;
        return this;
    }

    public final zzdz zzd() throws GeneralSecurityException {
        zzzq zzzq;
        zzzo zzb2;
        zzeh zzeh = this.zza;
        if (zzeh == null || (zzzq = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzeh.zzc() != zzzq.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzeh.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zza() || this.zzc == null) {
            if (this.zza.zzd() == zzef.zzc) {
                zzb2 = zzzo.zzb(new byte[0]);
            } else if (this.zza.zzd() == zzef.zzb) {
                zzb2 = zzzo.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzd() == zzef.zza) {
                zzb2 = zzzo.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: ".concat(String.valueOf(this.zza.zzd())));
            }
            return new zzdz(this.zza, this.zzb, zzb2, this.zzc, (zzdy) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
