package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbp  reason: invalid package */
class zzbp implements zzbo {
    private final zzng zza;
    private final Class zzb;

    public zzbp(zzng zzng, Class cls) {
        if (zzng.zzl().contains(cls) || Void.class.equals(cls)) {
            this.zza = zzng;
            this.zzb = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", new Object[]{zzng.toString(), cls.getName()}));
    }

    public final zzwi zza(zzajf zzajf) throws GeneralSecurityException {
        try {
            zznf zza2 = this.zza.zza();
            zzalp zzb2 = zza2.zzb(zzajf);
            zza2.zzd(zzb2);
            zzalp zza3 = zza2.zza(zzb2);
            zzwf zza4 = zzwi.zza();
            zza4.zzb(this.zza.zzd());
            zza4.zzc(zza3.zzo());
            zza4.zza(this.zza.zzb());
            return (zzwi) zza4.zzi();
        } catch (zzaks e10) {
            throw new GeneralSecurityException("Unexpected proto", e10);
        }
    }

    public final Object zzb(zzajf zzajf) throws GeneralSecurityException {
        try {
            zzalp zzc = this.zza.zzc(zzajf);
            if (!Void.class.equals(this.zzb)) {
                this.zza.zze(zzc);
                return this.zza.zzk(zzc, this.zzb);
            }
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        } catch (zzaks e10) {
            throw new GeneralSecurityException("Failures parsing proto of type ".concat(this.zza.zzj().getName()), e10);
        }
    }

    public final String zzc() {
        return this.zza.zzd();
    }
}
