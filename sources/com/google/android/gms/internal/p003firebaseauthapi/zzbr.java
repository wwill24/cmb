package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbr  reason: invalid package */
final class zzbr implements zzbs {
    final /* synthetic */ zzon zza;
    final /* synthetic */ zzng zzb;

    zzbr(zzon zzon, zzng zzng) {
        this.zza = zzon;
        this.zzb = zzng;
    }

    public final zzbo zza(Class cls) throws GeneralSecurityException {
        try {
            return new zzco(this.zza, this.zzb, cls);
        } catch (IllegalArgumentException e10) {
            throw new GeneralSecurityException("Primitive type not supported", e10);
        }
    }

    public final zzbo zzb() {
        zzon zzon = this.zza;
        return new zzco(zzon, this.zzb, zzon.zzi());
    }

    public final Class zzc() {
        return this.zza.getClass();
    }

    public final Class zzd() {
        return this.zzb.getClass();
    }

    public final Set zze() {
        return this.zza.zzl();
    }
}
