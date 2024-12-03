package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzye  reason: invalid package */
public final class zzye implements zzbj {
    private static final Collection zza = Arrays.asList(new Integer[]{64});
    private static final byte[] zzb = new byte[16];
    private final zzzg zzc;
    private final byte[] zzd;

    public zzye(byte[] bArr) throws GeneralSecurityException {
        if (zzij.zza(1)) {
            Collection collection = zza;
            int length = bArr.length;
            if (collection.contains(Integer.valueOf(length))) {
                int i10 = length >> 1;
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, i10);
                this.zzd = Arrays.copyOfRange(bArr, i10, length);
                this.zzc = new zzzg(copyOfRange);
                return;
            }
            throw new InvalidKeyException("invalid key size: " + length + " bytes; key must have 64 bytes");
        }
        throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        int length = bArr.length;
        if (length >= 16) {
            Cipher cipher = (Cipher) zzyv.zza.zza("AES/CTR/NoPadding");
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 16);
            byte[] bArr4 = (byte[]) copyOfRange.clone();
            bArr4[8] = (byte) (bArr4[8] & Byte.MAX_VALUE);
            bArr4[12] = (byte) (bArr4[12] & Byte.MAX_VALUE);
            cipher.init(2, new SecretKeySpec(this.zzd, "AES"), new IvParameterSpec(bArr4));
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 16, length);
            byte[] doFinal = cipher.doFinal(copyOfRange2);
            if (copyOfRange2.length == 0 && doFinal == null && zzzk.zza()) {
                doFinal = new byte[0];
            }
            byte[][] bArr5 = {bArr2, doFinal};
            byte[] zza2 = this.zzc.zza(zzb, 16);
            for (char c10 = 0; c10 <= 0; c10 = 1) {
                byte[] bArr6 = bArr5[0];
                if (bArr6 == null) {
                    bArr6 = new byte[0];
                }
                zza2 = zzyf.zzc(zzrd.zzb(zza2), this.zzc.zza(bArr6, 16));
            }
            byte[] bArr7 = bArr5[1];
            int length2 = bArr7.length;
            if (length2 >= 16) {
                int length3 = zza2.length;
                if (length2 >= length3) {
                    bArr3 = Arrays.copyOf(bArr7, length2);
                    for (int i10 = 0; i10 < zza2.length; i10++) {
                        int i11 = (length2 - length3) + i10;
                        bArr3[i11] = (byte) (bArr3[i11] ^ zza2[i10]);
                    }
                } else {
                    throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
                }
            } else {
                bArr3 = zzyf.zzc(zzrd.zza(bArr7), zzrd.zzb(zza2));
            }
            if (MessageDigest.isEqual(copyOfRange, this.zzc.zza(bArr3, 16))) {
                return doFinal;
            }
            throw new AEADBadTagException("Integrity check failed.");
        }
        throw new GeneralSecurityException("Ciphertext too short.");
    }
}
