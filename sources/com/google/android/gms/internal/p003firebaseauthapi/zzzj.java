package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzj  reason: invalid package */
public final class zzzj implements zzcd {
    private static final byte[] zza = {0};
    private final zzrw zzb;
    private final int zzc;
    private final byte[] zzd;
    private final byte[] zze;

    private zzzj(zzph zzph) throws GeneralSecurityException {
        this.zzb = new zzzg(zzph.zzd().zzc(zzbm.zza()));
        this.zzc = zzph.zza().zzb();
        this.zzd = zzph.zzc().zzc();
        if (zzph.zza().zze().equals(zzpp.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public static zzcd zzb(zzph zzph) throws GeneralSecurityException {
        return new zzzj(zzph);
    }

    public static zzcd zzc(zzqe zzqe) throws GeneralSecurityException {
        return new zzzj(zzqe);
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        byte[] bArr4 = this.zze;
        if (bArr4.length > 0) {
            bArr3 = zzyf.zzb(this.zzd, this.zzb.zza(zzyf.zzb(bArr2, bArr4), this.zzc));
        } else {
            bArr3 = zzyf.zzb(this.zzd, this.zzb.zza(bArr2, this.zzc));
        }
        if (!MessageDigest.isEqual(bArr3, bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    private zzzj(zzqe zzqe) throws GeneralSecurityException {
        String valueOf = String.valueOf(zzqe.zzd().zzf());
        this.zzb = new zzzi("HMAC".concat(valueOf), new SecretKeySpec(zzqe.zze().zzc(zzbm.zza()), "HMAC"));
        this.zzc = zzqe.zzd().zzb();
        this.zzd = zzqe.zzc().zzc();
        if (zzqe.zzd().zzg().equals(zzqn.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public zzzj(zzrw zzrw, int i10) throws GeneralSecurityException {
        this.zzb = zzrw;
        this.zzc = i10;
        this.zzd = new byte[0];
        this.zze = new byte[0];
        if (i10 >= 10) {
            zzrw.zza(new byte[0], i10);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }
}
