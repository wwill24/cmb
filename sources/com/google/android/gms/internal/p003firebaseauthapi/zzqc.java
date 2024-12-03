package com.google.android.gms.internal.p003firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqc  reason: invalid package */
public final class zzqc {
    private zzqp zza = null;
    private zzzq zzb = null;
    private Integer zzc = null;

    private zzqc() {
    }

    /* synthetic */ zzqc(zzqb zzqb) {
    }

    public final zzqc zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzqc zzb(zzzq zzzq) {
        this.zzb = zzzq;
        return this;
    }

    public final zzqc zzc(zzqp zzqp) {
        this.zza = zzqp;
        return this;
    }

    public final zzqe zzd() throws GeneralSecurityException {
        zzzq zzzq;
        zzzo zzb2;
        zzqp zzqp = this.zza;
        if (zzqp == null || (zzzq = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzqp.zzc() != zzzq.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzqp.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zza() || this.zzc == null) {
            if (this.zza.zzg() == zzqn.zzd) {
                zzb2 = zzzo.zzb(new byte[0]);
            } else if (this.zza.zzg() == zzqn.zzc || this.zza.zzg() == zzqn.zzb) {
                zzb2 = zzzo.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzg() == zzqn.zza) {
                zzb2 = zzzo.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown HmacParameters.Variant: ".concat(String.valueOf(this.zza.zzg())));
            }
            return new zzqe(this.zza, this.zzb, zzb2, this.zzc, (zzqd) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
