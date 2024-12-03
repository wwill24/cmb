package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzg  reason: invalid package */
public final class zzzg implements zzrw {
    private final SecretKey zza;
    private final byte[] zzb;
    private final byte[] zzc;

    public zzzg(byte[] bArr) throws GeneralSecurityException {
        zzzl.zzb(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zza = secretKeySpec;
        Cipher zzb2 = zzb();
        zzb2.init(1, secretKeySpec);
        byte[] zzb3 = zzrd.zzb(zzb2.doFinal(new byte[16]));
        this.zzb = zzb3;
        this.zzc = zzrd.zzb(zzb3);
    }

    private static Cipher zzb() throws GeneralSecurityException {
        if (zzij.zza(1)) {
            return (Cipher) zzyv.zza.zza("AES/ECB/NoPadding");
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    public final byte[] zza(byte[] bArr, int i10) throws GeneralSecurityException {
        byte[] bArr2;
        if (i10 <= 16) {
            SecretKey secretKey = this.zza;
            Cipher zzb2 = zzb();
            zzb2.init(1, secretKey);
            int length = bArr.length;
            int max = Math.max(1, (int) Math.ceil(((double) length) / 16.0d));
            int i11 = max - 1;
            int i12 = i11 * 16;
            if (max * 16 == length) {
                bArr2 = zzyf.zzd(bArr, i12, this.zzb, 0, 16);
            } else {
                bArr2 = zzyf.zzc(zzrd.zza(Arrays.copyOfRange(bArr, i12, length)), this.zzc);
            }
            byte[] bArr3 = new byte[16];
            for (int i13 = 0; i13 < i11; i13++) {
                bArr3 = zzb2.doFinal(zzyf.zzd(bArr3, 0, bArr, i13 * 16, 16));
            }
            return Arrays.copyOf(zzb2.doFinal(zzyf.zzc(bArr2, bArr3)), i10);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
