package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkl  reason: invalid package */
public final class zzkl {
    private zzkn zza;
    private zzkm zzb;
    private zzkh zzc;
    private zzko zzd;

    private zzkl() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        throw null;
    }

    /* synthetic */ zzkl(zzkk zzkk) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzko.zzc;
    }

    public final zzkl zza(zzkh zzkh) {
        this.zzc = zzkh;
        return this;
    }

    public final zzkl zzb(zzkm zzkm) {
        this.zzb = zzkm;
        return this;
    }

    public final zzkl zzc(zzkn zzkn) {
        this.zza = zzkn;
        return this;
    }

    public final zzkl zzd(zzko zzko) {
        this.zzd = zzko;
        return this;
    }

    public final zzkq zze() throws GeneralSecurityException {
        zzkn zzkn = this.zza;
        if (zzkn != null) {
            zzkm zzkm = this.zzb;
            if (zzkm != null) {
                zzkh zzkh = this.zzc;
                if (zzkh != null) {
                    zzko zzko = this.zzd;
                    if (zzko != null) {
                        return new zzkq(zzkn, zzkm, zzkh, zzko, (zzkp) null);
                    }
                    throw new GeneralSecurityException("HPKE variant is not set");
                }
                throw new GeneralSecurityException("HPKE AEAD parameter is not set");
            }
            throw new GeneralSecurityException("HPKE KDF parameter is not set");
        }
        throw new GeneralSecurityException("HPKE KEM parameter is not set");
    }
}
