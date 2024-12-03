package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqp  reason: invalid package */
public final class zzqp extends zzqs {
    private final int zza;
    private final int zzb;
    private final zzqn zzc;
    private final zzqm zzd;

    /* synthetic */ zzqp(int i10, int i11, zzqn zzqn, zzqm zzqm, zzqo zzqo) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = zzqn;
        this.zzd = zzqm;
    }

    public static zzql zze() {
        return new zzql((zzqk) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzqp)) {
            return false;
        }
        zzqp zzqp = (zzqp) obj;
        if (zzqp.zza == this.zza && zzqp.zzd() == zzd() && zzqp.zzc == this.zzc && zzqp.zzd == this.zzd) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzqp.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final String toString() {
        zzqm zzqm = this.zzd;
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(zzqm);
        return "HMAC Parameters (variant: " + valueOf + ", hashType: " + valueOf2 + ", " + this.zzb + "-byte tags, and " + this.zza + "-byte key)";
    }

    public final boolean zza() {
        return this.zzc != zzqn.zzd;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        zzqn zzqn = this.zzc;
        if (zzqn == zzqn.zzd) {
            return this.zzb;
        }
        if (zzqn == zzqn.zza || zzqn == zzqn.zzb || zzqn == zzqn.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzqm zzf() {
        return this.zzd;
    }

    public final zzqn zzg() {
        return this.zzc;
    }
}
