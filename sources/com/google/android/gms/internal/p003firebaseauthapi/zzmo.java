package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import org.bouncycastle.crypto.signers.PSSSigner;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmo  reason: invalid package */
public final class zzmo {
    static final byte[][] zza = {new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{-32, -21, 122, 124, 59, 65, -72, -82, 22, 86, -29, -6, -15, -97, -60, 106, -38, 9, -115, -21, -100, Framer.STDERR_FRAME_PREFIX, -79, -3, -122, 98, 5, 22, Framer.STDIN_REQUEST_FRAME_PREFIX, 73, -72, 0}, new byte[]{Framer.STDIN_REQUEST_FRAME_PREFIX, -100, -107, PSSSigner.TRAILER_IMPLICIT, -93, 80, -116, 36, -79, -48, -79, 85, -100, -125, -17, 91, 4, 68, 92, -60, 88, 28, -114, -122, -40, 34, 78, -35, -48, -97, 17, 87}, new byte[]{-20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, new byte[]{-19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, new byte[]{-18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}};

    public static void zza(long[] jArr, byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        long[] jArr2 = jArr;
        byte[] bArr3 = bArr2;
        int i10 = 32;
        if (bArr3.length == 32) {
            byte[] copyOf = Arrays.copyOf(bArr3, 32);
            copyOf[31] = (byte) (copyOf[31] & Byte.MAX_VALUE);
            int i11 = 0;
            int i12 = 0;
            while (i12 < 7) {
                byte[][] bArr4 = zza;
                if (!MessageDigest.isEqual(bArr4[i12], copyOf)) {
                    i12++;
                } else {
                    throw new InvalidKeyException("Banned public key: ".concat(zzze.zza(bArr4[i12])));
                }
            }
            long[] zzk = zzmv.zzk(copyOf);
            long[] jArr3 = new long[19];
            long[] jArr4 = new long[19];
            jArr4[0] = 1;
            long[] jArr5 = new long[19];
            jArr5[0] = 1;
            long[] jArr6 = new long[19];
            long[] jArr7 = new long[19];
            long[] jArr8 = new long[19];
            jArr8[0] = 1;
            long[] jArr9 = new long[19];
            long[] jArr10 = new long[19];
            jArr10[0] = 1;
            int i13 = 10;
            System.arraycopy(zzk, 0, jArr3, 0, 10);
            int i14 = 0;
            while (i14 < i10) {
                byte b10 = bArr[(32 - i14) - 1] & 255;
                while (i11 < 8) {
                    int i15 = (b10 >> (7 - i11)) & 1;
                    zzb(jArr5, jArr3, i15);
                    zzb(jArr6, jArr4, i15);
                    long[] copyOf2 = Arrays.copyOf(jArr5, i13);
                    byte b11 = b10;
                    long[] jArr11 = new long[19];
                    int i16 = i14;
                    long[] jArr12 = new long[19];
                    int i17 = i11;
                    long[] jArr13 = new long[19];
                    int i18 = i15;
                    long[] jArr14 = new long[19];
                    long[] jArr15 = jArr10;
                    long[] jArr16 = new long[19];
                    long[] jArr17 = new long[19];
                    zzmv.zzi(jArr5, jArr5, jArr6);
                    zzmv.zzh(jArr6, copyOf2, jArr6);
                    long[] copyOf3 = Arrays.copyOf(jArr3, 10);
                    zzmv.zzi(jArr3, jArr3, jArr4);
                    zzmv.zzh(jArr4, copyOf3, jArr4);
                    zzmv.zzb(jArr13, jArr3, jArr6);
                    zzmv.zzb(jArr14, jArr5, jArr4);
                    zzmv.zze(jArr13);
                    zzmv.zzd(jArr13);
                    zzmv.zze(jArr14);
                    zzmv.zzd(jArr14);
                    long[] jArr18 = jArr3;
                    System.arraycopy(jArr13, 0, copyOf3, 0, 10);
                    zzmv.zzi(jArr13, jArr13, jArr14);
                    zzmv.zzh(jArr14, copyOf3, jArr14);
                    zzmv.zzg(jArr17, jArr13);
                    zzmv.zzg(jArr16, jArr14);
                    zzmv.zzb(jArr14, jArr16, zzk);
                    zzmv.zze(jArr14);
                    zzmv.zzd(jArr14);
                    System.arraycopy(jArr17, 0, jArr7, 0, 10);
                    System.arraycopy(jArr14, 0, jArr8, 0, 10);
                    zzmv.zzg(jArr11, jArr5);
                    zzmv.zzg(jArr12, jArr6);
                    zzmv.zzb(jArr9, jArr11, jArr12);
                    zzmv.zze(jArr9);
                    zzmv.zzd(jArr9);
                    zzmv.zzh(jArr12, jArr11, jArr12);
                    long[] jArr19 = new long[19];
                    Arrays.fill(jArr19, 10, 18, 0);
                    zzmv.zzf(jArr19, jArr12, 121665);
                    zzmv.zzd(jArr19);
                    zzmv.zzi(jArr19, jArr19, jArr11);
                    long[] jArr20 = jArr15;
                    zzmv.zzb(jArr20, jArr12, jArr19);
                    zzmv.zze(jArr20);
                    zzmv.zzd(jArr20);
                    int i19 = i18;
                    zzb(jArr9, jArr7, i19);
                    zzb(jArr20, jArr8, i19);
                    i11 = i17 + 1;
                    long[] jArr21 = jArr;
                    byte[] bArr5 = bArr2;
                    jArr3 = jArr7;
                    b10 = b11;
                    i14 = i16;
                    jArr7 = jArr18;
                    i13 = 10;
                    long[] jArr22 = jArr8;
                    jArr8 = jArr4;
                    jArr4 = jArr22;
                    long[] jArr23 = jArr9;
                    jArr9 = jArr5;
                    jArr5 = jArr23;
                    long[] jArr24 = jArr20;
                    jArr10 = jArr6;
                    jArr6 = jArr24;
                }
                long[] jArr25 = jArr3;
                i14++;
                long[] jArr26 = jArr;
                byte[] bArr6 = bArr2;
                i10 = 32;
                i11 = 0;
                i13 = 10;
            }
            int i20 = i13;
            long[] jArr27 = new long[i20];
            long[] jArr28 = new long[i20];
            long[] jArr29 = new long[i20];
            long[] jArr30 = new long[i20];
            long[] jArr31 = new long[i20];
            long[] jArr32 = new long[i20];
            long[] jArr33 = new long[i20];
            long[] jArr34 = new long[i20];
            long[] jArr35 = new long[i20];
            long[] jArr36 = new long[i20];
            long[] jArr37 = jArr3;
            long[] jArr38 = new long[i20];
            zzmv.zzg(jArr28, jArr6);
            zzmv.zzg(jArr38, jArr28);
            zzmv.zzg(jArr36, jArr38);
            zzmv.zza(jArr29, jArr36, jArr6);
            zzmv.zza(jArr30, jArr29, jArr28);
            zzmv.zzg(jArr36, jArr30);
            zzmv.zza(jArr31, jArr36, jArr29);
            zzmv.zzg(jArr36, jArr31);
            zzmv.zzg(jArr38, jArr36);
            zzmv.zzg(jArr36, jArr38);
            zzmv.zzg(jArr38, jArr36);
            zzmv.zzg(jArr36, jArr38);
            zzmv.zza(jArr32, jArr36, jArr31);
            zzmv.zzg(jArr36, jArr32);
            zzmv.zzg(jArr38, jArr36);
            for (int i21 = 2; i21 < 10; i21 += 2) {
                zzmv.zzg(jArr36, jArr38);
                zzmv.zzg(jArr38, jArr36);
            }
            zzmv.zza(jArr33, jArr38, jArr32);
            zzmv.zzg(jArr36, jArr33);
            zzmv.zzg(jArr38, jArr36);
            for (int i22 = 2; i22 < 20; i22 += 2) {
                zzmv.zzg(jArr36, jArr38);
                zzmv.zzg(jArr38, jArr36);
            }
            zzmv.zza(jArr36, jArr38, jArr33);
            zzmv.zzg(jArr38, jArr36);
            zzmv.zzg(jArr36, jArr38);
            for (int i23 = 2; i23 < 10; i23 += 2) {
                zzmv.zzg(jArr38, jArr36);
                zzmv.zzg(jArr36, jArr38);
            }
            zzmv.zza(jArr34, jArr36, jArr32);
            zzmv.zzg(jArr36, jArr34);
            zzmv.zzg(jArr38, jArr36);
            for (int i24 = 2; i24 < 50; i24 += 2) {
                zzmv.zzg(jArr36, jArr38);
                zzmv.zzg(jArr38, jArr36);
            }
            zzmv.zza(jArr35, jArr38, jArr34);
            zzmv.zzg(jArr38, jArr35);
            zzmv.zzg(jArr36, jArr38);
            for (int i25 = 2; i25 < 100; i25 += 2) {
                zzmv.zzg(jArr38, jArr36);
                zzmv.zzg(jArr36, jArr38);
            }
            zzmv.zza(jArr38, jArr36, jArr35);
            zzmv.zzg(jArr36, jArr38);
            zzmv.zzg(jArr38, jArr36);
            for (int i26 = 2; i26 < 50; i26 += 2) {
                zzmv.zzg(jArr36, jArr38);
                zzmv.zzg(jArr38, jArr36);
            }
            zzmv.zza(jArr36, jArr38, jArr34);
            zzmv.zzg(jArr38, jArr36);
            zzmv.zzg(jArr36, jArr38);
            zzmv.zzg(jArr38, jArr36);
            zzmv.zzg(jArr36, jArr38);
            zzmv.zzg(jArr38, jArr36);
            zzmv.zza(jArr27, jArr38, jArr30);
            long[] jArr39 = jArr;
            zzmv.zza(jArr39, jArr5, jArr27);
            long[] jArr40 = new long[10];
            long[] jArr41 = new long[10];
            long[] jArr42 = new long[11];
            long[] jArr43 = new long[11];
            long[] jArr44 = new long[11];
            zzmv.zza(jArr40, zzk, jArr39);
            zzmv.zzi(jArr41, zzk, jArr39);
            long[] jArr45 = new long[10];
            jArr45[0] = 486662;
            zzmv.zzi(jArr43, jArr41, jArr45);
            zzmv.zza(jArr43, jArr43, jArr4);
            long[] jArr46 = jArr37;
            zzmv.zzi(jArr43, jArr43, jArr46);
            zzmv.zza(jArr43, jArr43, jArr40);
            zzmv.zza(jArr43, jArr43, jArr46);
            zzmv.zzf(jArr42, jArr43, 4);
            zzmv.zzd(jArr42);
            zzmv.zza(jArr43, jArr40, jArr4);
            zzmv.zzh(jArr43, jArr43, jArr4);
            zzmv.zza(jArr44, jArr41, jArr46);
            zzmv.zzi(jArr43, jArr43, jArr44);
            zzmv.zzg(jArr43, jArr43);
            if (!MessageDigest.isEqual(zzmv.zzj(jArr42), zzmv.zzj(jArr43))) {
                throw new IllegalStateException("Arithmetic error in curve multiplication with the public key: ".concat(zzze.zza(bArr2)));
            }
            return;
        }
        throw new InvalidKeyException("Public key length is not 32-byte");
    }

    static void zzb(long[] jArr, long[] jArr2, int i10) {
        for (int i11 = 0; i11 < 10; i11++) {
            int i12 = (int) jArr[i11];
            int i13 = (-i10) & (((int) jArr2[i11]) ^ i12);
            jArr[i11] = (long) (i12 ^ i13);
            jArr2[i11] = (long) (i13 ^ ((int) jArr2[i11]));
        }
    }
}
