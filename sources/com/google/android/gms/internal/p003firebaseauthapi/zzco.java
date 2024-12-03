package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzco  reason: invalid package */
final class zzco extends zzbp implements zzcn {
    private final zzon zza;
    private final zzng zzb;

    public zzco(zzon zzon, zzng zzng, Class cls) {
        super(zzon, cls);
        this.zza = zzon;
        this.zzb = zzng;
    }

    public final zzwi zzd(zzajf zzajf) throws GeneralSecurityException {
        try {
            zzalp zzc = this.zza.zzc(zzajf);
            this.zza.zze(zzc);
            zzalp zzg = this.zza.zzg(zzc);
            this.zzb.zze(zzg);
            zzwf zza2 = zzwi.zza();
            zza2.zzb(this.zzb.zzd());
            zza2.zzc(zzg.zzo());
            zza2.zza(this.zzb.zzb());
            return (zzwi) zza2.zzi();
        } catch (zzaks e10) {
            throw new GeneralSecurityException("expected serialized proto of type ", e10);
        }
    }
}
