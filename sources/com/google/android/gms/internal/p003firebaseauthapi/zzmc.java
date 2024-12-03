package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmc  reason: invalid package */
final class zzmc implements zzlt {
    private final zzln zza;
    private final int zzb;

    private zzmc(zzln zzln, int i10) {
        this.zza = zzln;
        this.zzb = i10;
    }

    static zzmc zzc(int i10) throws GeneralSecurityException {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return new zzmc(new zzln("HmacSha256"), 1);
        }
        if (i11 != 1) {
            return new zzmc(new zzln("HmacSha512"), 3);
        }
        return new zzmc(new zzln("HmacSha384"), 2);
    }

    public final byte[] zza(byte[] bArr, zzlu zzlu) throws GeneralSecurityException {
        byte[] zzf = zzym.zzf(zzym.zzg(this.zzb, zzlu.zza().zzc()), zzym.zzh(zzym.zzi(this.zzb), 1, bArr));
        byte[] zzb2 = zzyf.zzb(bArr, zzlu.zzb().zzc());
        byte[] zze = zzmb.zze(zzb());
        zzln zzln = this.zza;
        return zzln.zzb((byte[]) null, zzf, "eae_prk", zzb2, "shared_secret", zze, zzln.zza());
    }

    public final byte[] zzb() throws GeneralSecurityException {
        int i10 = this.zzb - 1;
        if (i10 == 0) {
            return zzmb.zzd;
        }
        if (i10 != 1) {
            return zzmb.zzf;
        }
        return zzmb.zze;
    }
}
