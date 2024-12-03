package com.google.android.gms.internal.p003firebaseauthapi;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyd  reason: invalid package */
public final class zzyd implements zzbd {
    private final zzhz zza;
    private final byte[] zzb;

    public zzyd(byte[] bArr) throws GeneralSecurityException {
        zzzo zzb2 = zzzo.zzb(new byte[0]);
        if (zzij.zza(2)) {
            this.zza = new zzhz(bArr, true);
            this.zzb = zzb2.zzc();
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        int length = bArr3.length;
        if (length == 0) {
            return this.zza.zza(Arrays.copyOf(bArr, 12), bArr, bArr2);
        }
        Charset charset = zzpd.zza;
        if (bArr.length >= length) {
            int i10 = 0;
            while (i10 < bArr3.length) {
                if (bArr[i10] == bArr3[i10]) {
                    i10++;
                }
            }
            byte[] bArr4 = this.zzb;
            byte[] copyOfRange = Arrays.copyOfRange(bArr, bArr4.length, bArr.length);
            return this.zza.zza(Arrays.copyOf(copyOfRange, 12), copyOfRange, bArr2);
        }
        throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
