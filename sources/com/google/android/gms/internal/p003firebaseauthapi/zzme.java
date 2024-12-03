package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzme  reason: invalid package */
final class zzme implements zzlt {
    private final zzln zza;

    zzme(zzln zzln) {
        this.zza = zzln;
    }

    public final byte[] zza(byte[] bArr, zzlu zzlu) throws GeneralSecurityException {
        byte[] zza2 = zzzm.zza(zzlu.zza().zzc(), bArr);
        byte[] zzb = zzyf.zzb(bArr, zzlu.zzb().zzc());
        byte[] zze = zzmb.zze(zzmb.zzc);
        zzln zzln = this.zza;
        return zzln.zzb((byte[]) null, zza2, "eae_prk", zzb, "shared_secret", zze, zzln.zza());
    }

    public final byte[] zzb() throws GeneralSecurityException {
        if (Arrays.equals(this.zza.zzc(), zzmb.zzg)) {
            return zzmb.zzc;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
