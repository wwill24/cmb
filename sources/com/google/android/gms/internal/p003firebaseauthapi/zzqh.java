package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqh  reason: invalid package */
final class zzqh extends zzog {
    zzqh(Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ Object zza(zzalp zzalp) throws GeneralSecurityException {
        zzvf zzvf = (zzvf) zzalp;
        zzvc zzb = zzvf.zzf().zzb();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzvf.zzg().zzq(), "HMAC");
        int zza = zzvf.zzf().zza();
        zzvc zzvc = zzvc.UNKNOWN_HASH;
        int ordinal = zzb.ordinal();
        if (ordinal == 1) {
            return new zzzj(new zzzi("HMACSHA1", secretKeySpec), zza);
        }
        if (ordinal == 2) {
            return new zzzj(new zzzi("HMACSHA384", secretKeySpec), zza);
        }
        if (ordinal == 3) {
            return new zzzj(new zzzi("HMACSHA256", secretKeySpec), zza);
        }
        if (ordinal == 4) {
            return new zzzj(new zzzi("HMACSHA512", secretKeySpec), zza);
        }
        if (ordinal == 5) {
            return new zzzj(new zzzi("HMACSHA224", secretKeySpec), zza);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}
