package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmv  reason: invalid package */
public final class zzmv {
    private static final int[] zza = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
    private static final int[] zzb = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
    private static final int[] zzc = {67108863, 33554431};
    private static final int[] zzd = {26, 25};

    static void zza(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[19];
        zzb(jArr4, jArr2, jArr3);
        zzc(jArr4, jArr);
    }

    /* JADX WARNING: type inference failed for: r56v0, types: [long[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void zzb(long[] r56, long[] r57, long[] r58) {
        /*
            r0 = 0
            r1 = r57[r0]
            r3 = r58[r0]
            long r1 = r1 * r3
            r56[r0] = r1
            r1 = r57[r0]
            r3 = 1
            r4 = r58[r3]
            long r4 = r4 * r1
            r6 = r57[r3]
            r8 = r58[r0]
            long r6 = r6 * r8
            long r4 = r4 + r6
            r56[r3] = r4
            r4 = r57[r3]
            long r6 = r4 + r4
            r10 = r58[r3]
            long r6 = r6 * r10
            r0 = 2
            r12 = r58[r0]
            long r12 = r12 * r1
            r14 = r57[r0]
            long r14 = r14 * r8
            long r6 = r6 + r12
            long r6 = r6 + r14
            r56[r0] = r6
            r6 = r58[r0]
            long r12 = r4 * r6
            r14 = r57[r0]
            long r16 = r14 * r10
            r0 = 3
            r18 = r58[r0]
            long r18 = r18 * r1
            r20 = r57[r0]
            long r20 = r20 * r8
            long r12 = r12 + r16
            long r12 = r12 + r18
            long r12 = r12 + r20
            r56[r0] = r12
            long r12 = r14 * r6
            r16 = r58[r0]
            long r18 = r4 * r16
            r20 = r57[r0]
            long r22 = r20 * r10
            r0 = 4
            r24 = r58[r0]
            long r24 = r24 * r1
            r26 = r57[r0]
            long r26 = r26 * r8
            long r18 = r18 + r22
            long r18 = r18 + r18
            long r12 = r12 + r18
            long r12 = r12 + r24
            long r12 = r12 + r26
            r56[r0] = r12
            long r12 = r14 * r16
            long r18 = r20 * r6
            r22 = r58[r0]
            long r24 = r4 * r22
            r26 = r57[r0]
            long r28 = r26 * r10
            r0 = 5
            r30 = r58[r0]
            long r30 = r30 * r1
            r32 = r57[r0]
            long r32 = r32 * r8
            long r12 = r12 + r18
            long r12 = r12 + r24
            long r12 = r12 + r28
            long r12 = r12 + r30
            long r12 = r12 + r32
            r56[r0] = r12
            long r12 = r20 * r16
            r18 = r58[r0]
            long r24 = r4 * r18
            r28 = r57[r0]
            long r30 = r28 * r10
            long r32 = r14 * r22
            long r34 = r26 * r6
            r0 = 6
            r36 = r58[r0]
            long r36 = r36 * r1
            r38 = r57[r0]
            long r38 = r38 * r8
            long r12 = r12 + r24
            long r12 = r12 + r30
            long r12 = r12 + r12
            long r12 = r12 + r32
            long r12 = r12 + r34
            long r12 = r12 + r36
            long r12 = r12 + r38
            r56[r0] = r12
            long r12 = r20 * r22
            long r24 = r26 * r16
            long r30 = r14 * r18
            long r32 = r28 * r6
            r34 = r58[r0]
            long r36 = r4 * r34
            r38 = r57[r0]
            long r40 = r38 * r10
            r0 = 7
            r42 = r58[r0]
            long r42 = r42 * r1
            r44 = r57[r0]
            long r44 = r44 * r8
            long r12 = r12 + r24
            long r12 = r12 + r30
            long r12 = r12 + r32
            long r12 = r12 + r36
            long r12 = r12 + r40
            long r12 = r12 + r42
            long r12 = r12 + r44
            r56[r0] = r12
            long r12 = r26 * r22
            long r24 = r20 * r18
            long r30 = r28 * r16
            r32 = r58[r0]
            long r36 = r4 * r32
            r40 = r57[r0]
            long r42 = r40 * r10
            long r44 = r14 * r34
            long r46 = r38 * r6
            r0 = 8
            r48 = r58[r0]
            long r48 = r48 * r1
            r50 = r57[r0]
            long r50 = r50 * r8
            long r24 = r24 + r30
            long r24 = r24 + r36
            long r24 = r24 + r42
            long r24 = r24 + r24
            long r12 = r12 + r24
            long r12 = r12 + r44
            long r12 = r12 + r46
            long r12 = r12 + r48
            long r12 = r12 + r50
            r56[r0] = r12
            long r12 = r26 * r18
            long r24 = r28 * r22
            long r30 = r20 * r34
            long r36 = r38 * r16
            long r42 = r14 * r32
            long r44 = r40 * r6
            r46 = r58[r0]
            long r48 = r4 * r46
            r50 = r57[r0]
            long r52 = r50 * r10
            r0 = 9
            r54 = r58[r0]
            long r1 = r1 * r54
            r54 = r57[r0]
            long r54 = r54 * r8
            long r12 = r12 + r24
            long r12 = r12 + r30
            long r12 = r12 + r36
            long r12 = r12 + r42
            long r12 = r12 + r44
            long r12 = r12 + r48
            long r12 = r12 + r52
            long r12 = r12 + r1
            long r12 = r12 + r54
            r56[r0] = r12
            long r1 = r28 * r18
            long r8 = r20 * r32
            long r12 = r40 * r16
            r24 = r58[r0]
            long r4 = r4 * r24
            r30 = r57[r0]
            long r10 = r10 * r30
            long r36 = r26 * r34
            long r42 = r38 * r22
            long r44 = r14 * r46
            long r48 = r50 * r6
            long r1 = r1 + r8
            long r1 = r1 + r12
            long r1 = r1 + r4
            long r1 = r1 + r10
            long r1 = r1 + r1
            long r1 = r1 + r36
            long r1 = r1 + r42
            long r1 = r1 + r44
            long r1 = r1 + r48
            r0 = 10
            r56[r0] = r1
            long r0 = r28 * r34
            long r2 = r38 * r18
            long r4 = r26 * r32
            long r8 = r40 * r22
            long r10 = r20 * r46
            long r12 = r50 * r16
            long r14 = r14 * r24
            long r6 = r6 * r30
            long r0 = r0 + r2
            long r0 = r0 + r4
            long r0 = r0 + r8
            long r0 = r0 + r10
            long r0 = r0 + r12
            long r0 = r0 + r14
            long r0 = r0 + r6
            r2 = 11
            r56[r2] = r0
            long r0 = r38 * r34
            long r2 = r28 * r32
            long r4 = r40 * r18
            long r20 = r20 * r24
            long r16 = r16 * r30
            long r6 = r26 * r46
            long r8 = r50 * r22
            long r2 = r2 + r4
            long r2 = r2 + r20
            long r2 = r2 + r16
            long r2 = r2 + r2
            long r0 = r0 + r2
            long r0 = r0 + r6
            long r0 = r0 + r8
            r2 = 12
            r56[r2] = r0
            long r0 = r38 * r32
            long r2 = r40 * r34
            long r4 = r28 * r46
            long r6 = r50 * r18
            long r26 = r26 * r24
            long r22 = r22 * r30
            long r0 = r0 + r2
            long r0 = r0 + r4
            long r0 = r0 + r6
            long r0 = r0 + r26
            long r0 = r0 + r22
            r2 = 13
            r56[r2] = r0
            long r0 = r40 * r32
            long r28 = r28 * r24
            long r18 = r18 * r30
            long r2 = r38 * r46
            long r4 = r50 * r34
            long r0 = r0 + r28
            long r0 = r0 + r18
            long r0 = r0 + r0
            long r0 = r0 + r2
            long r0 = r0 + r4
            r2 = 14
            r56[r2] = r0
            long r0 = r40 * r46
            long r2 = r50 * r32
            long r38 = r38 * r24
            long r34 = r34 * r30
            long r0 = r0 + r2
            long r0 = r0 + r38
            long r0 = r0 + r34
            r2 = 15
            r56[r2] = r0
            long r0 = r50 * r46
            long r40 = r40 * r24
            long r32 = r32 * r30
            long r40 = r40 + r32
            long r40 = r40 + r40
            long r0 = r0 + r40
            r2 = 16
            r56[r2] = r0
            long r50 = r50 * r24
            long r46 = r46 * r30
            long r50 = r50 + r46
            r0 = 17
            r56[r0] = r50
            long r30 = r30 + r30
            long r30 = r30 * r24
            r0 = 18
            r56[r0] = r30
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p003firebaseauthapi.zzmv.zzb(long[], long[], long[]):void");
    }

    static void zzc(long[] jArr, long[] jArr2) {
        zze(jArr);
        zzd(jArr);
        System.arraycopy(jArr, 0, jArr2, 0, 10);
    }

    static void zzd(long[] jArr) {
        jArr[10] = 0;
        int i10 = 0;
        while (i10 < 10) {
            long j10 = jArr[i10];
            long j11 = j10 / 67108864;
            jArr[i10] = j10 - (j11 << 26);
            int i11 = i10 + 1;
            long j12 = jArr[i11] + j11;
            jArr[i11] = j12;
            long j13 = j12 / 33554432;
            jArr[i11] = j12 - (j13 << 25);
            i10 += 2;
            jArr[i10] = jArr[i10] + j13;
        }
        long j14 = jArr[0];
        long j15 = jArr[10];
        long j16 = j14 + (j15 << 4);
        jArr[0] = j16;
        long j17 = j16 + j15 + j15;
        jArr[0] = j17;
        long j18 = j17 + j15;
        jArr[0] = j18;
        jArr[10] = 0;
        long j19 = j18 / 67108864;
        jArr[0] = j18 - (j19 << 26);
        jArr[1] = jArr[1] + j19;
    }

    static void zze(long[] jArr) {
        long j10 = jArr[8];
        long j11 = jArr[18];
        long j12 = j10 + (j11 << 4);
        jArr[8] = j12;
        long j13 = j12 + j11 + j11;
        jArr[8] = j13;
        jArr[8] = j13 + j11;
        long j14 = jArr[7];
        long j15 = jArr[17];
        long j16 = j14 + (j15 << 4);
        jArr[7] = j16;
        long j17 = j16 + j15 + j15;
        jArr[7] = j17;
        jArr[7] = j17 + j15;
        long j18 = jArr[6];
        long j19 = jArr[16];
        long j20 = j18 + (j19 << 4);
        jArr[6] = j20;
        long j21 = j20 + j19 + j19;
        jArr[6] = j21;
        jArr[6] = j21 + j19;
        long j22 = jArr[5];
        long j23 = jArr[15];
        long j24 = j22 + (j23 << 4);
        jArr[5] = j24;
        long j25 = j24 + j23 + j23;
        jArr[5] = j25;
        jArr[5] = j25 + j23;
        long j26 = jArr[4];
        long j27 = jArr[14];
        long j28 = j26 + (j27 << 4);
        jArr[4] = j28;
        long j29 = j28 + j27 + j27;
        jArr[4] = j29;
        jArr[4] = j29 + j27;
        long j30 = jArr[3];
        long j31 = jArr[13];
        long j32 = j30 + (j31 << 4);
        jArr[3] = j32;
        long j33 = j32 + j31 + j31;
        jArr[3] = j33;
        jArr[3] = j33 + j31;
        long j34 = jArr[2];
        long j35 = jArr[12];
        long j36 = j34 + (j35 << 4);
        jArr[2] = j36;
        long j37 = j36 + j35 + j35;
        jArr[2] = j37;
        jArr[2] = j37 + j35;
        long j38 = jArr[1];
        long j39 = jArr[11];
        long j40 = j38 + (j39 << 4);
        jArr[1] = j40;
        long j41 = j40 + j39 + j39;
        jArr[1] = j41;
        jArr[1] = j41 + j39;
        long j42 = jArr[0];
        long j43 = jArr[10];
        long j44 = j42 + (j43 << 4);
        jArr[0] = j44;
        long j45 = j44 + j43 + j43;
        jArr[0] = j45;
        jArr[0] = j45 + j43;
    }

    static void zzf(long[] jArr, long[] jArr2, long j10) {
        for (int i10 = 0; i10 < 10; i10++) {
            jArr[i10] = jArr2[i10] * j10;
        }
    }

    static void zzg(long[] jArr, long[] jArr2) {
        long j10 = jArr2[0];
        long j11 = jArr2[0];
        long j12 = jArr2[1];
        long j13 = (j12 * j12) + (jArr2[2] * j11);
        long j14 = jArr2[2];
        long j15 = (j12 * j14) + (jArr2[3] * j11);
        long j16 = jArr2[3];
        long j17 = (j14 * j14) + (j12 * 4 * j16);
        long j18 = jArr2[4];
        long j19 = (j14 * j16) + (j12 * j18) + (jArr2[5] * j11);
        long j20 = jArr2[5];
        long j21 = (j16 * j16) + (j14 * j18) + (jArr2[6] * j11) + ((j12 + j12) * j20);
        long j22 = jArr2[6];
        long j23 = (j16 * j18) + (j14 * j20) + (j12 * j22) + (jArr2[7] * j11);
        long j24 = jArr2[7];
        long j25 = (j12 * j24) + (j16 * j20);
        long j26 = (j14 * j22) + (jArr2[8] * j11) + j25 + j25;
        long j27 = jArr2[8];
        long j28 = (j18 * j20) + (j16 * j22) + (j14 * j24) + (j12 * j27) + (j11 * jArr2[9]);
        long j29 = jArr2[9];
        long j30 = (j16 * j24) + (j12 * j29);
        long j31 = (j20 * j20) + (j18 * j22) + (j14 * j27) + j30 + j30;
        long j32 = (j20 * j22) + (j18 * j24) + (j16 * j27) + (j14 * j29);
        long j33 = (j20 * j24) + (j16 * j29);
        long j34 = (j18 * j27) + j33 + j33;
        long j35 = (j22 * j24) + (j20 * j27) + (j18 * j29);
        long j36 = (j24 * j24) + (j22 * j27) + ((j20 + j20) * j29);
        long j37 = (j24 * j27) + (j22 * j29);
        zzc(new long[]{j10 * j10, (j11 + j11) * jArr2[1], j13 + j13, j15 + j15, j17 + ((j11 + j11) * jArr2[4]), j19 + j19, j21 + j21, j23 + j23, (j18 * j18) + j26 + j26, j28 + j28, j31 + j31, j32 + j32, (j22 * j22) + j34 + j34, j35 + j35, j36 + j36, j37 + j37, (j27 * j27) + (j24 * 4 * j29), (j27 + j27) * j29, (j29 + j29) * j29}, jArr);
    }

    static void zzh(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i10 = 0; i10 < 10; i10++) {
            jArr[i10] = jArr2[i10] - jArr3[i10];
        }
    }

    static void zzi(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i10 = 0; i10 < 10; i10++) {
            jArr[i10] = jArr2[i10] + jArr3[i10];
        }
    }

    public static byte[] zzj(long[] jArr) {
        int i10;
        long[] copyOf = Arrays.copyOf(jArr, 10);
        int i11 = 0;
        while (true) {
            if (i11 >= 2) {
                break;
            }
            int i12 = 0;
            while (i12 < 9) {
                long j10 = copyOf[i12];
                int i13 = zzd[i12 & 1];
                int i14 = -((int) (((j10 >> 31) & j10) >> i13));
                copyOf[i12] = j10 + ((long) (i14 << i13));
                i12++;
                copyOf[i12] = copyOf[i12] - ((long) i14);
            }
            long j11 = copyOf[9];
            int i15 = -((int) (((j11 >> 31) & j11) >> 25));
            copyOf[9] = j11 + ((long) (i15 << 25));
            copyOf[0] = copyOf[0] - (((long) i15) * 19);
            i11++;
        }
        long j12 = copyOf[0];
        int i16 = -((int) (((j12 >> 31) & j12) >> 26));
        copyOf[0] = j12 + ((long) (i16 << 26));
        copyOf[1] = copyOf[1] - ((long) i16);
        int i17 = 0;
        for (i10 = 2; i17 < i10; i10 = 2) {
            int i18 = 0;
            while (i18 < 9) {
                long j13 = copyOf[i18];
                int i19 = i18 & 1;
                long j14 = j13 >> zzd[i19];
                copyOf[i18] = j13 & ((long) zzc[i19]);
                i18++;
                copyOf[i18] = copyOf[i18] + ((long) ((int) j14));
            }
            i17++;
        }
        long j15 = copyOf[9];
        copyOf[9] = j15 & 33554431;
        long j16 = copyOf[0] + (((long) ((int) (j15 >> 25))) * 19);
        copyOf[0] = j16;
        int i20 = ~((((int) j16) - 67108845) >> 31);
        for (int i21 = 1; i21 < 10; i21++) {
            int i22 = ~(((int) copyOf[i21]) ^ zzc[i21 & 1]);
            int i23 = i22 & (i22 << 16);
            int i24 = i23 & (i23 << 8);
            int i25 = i24 & (i24 << 4);
            int i26 = i25 & (i25 << 2);
            i20 &= (i26 & (i26 + i26)) >> 31;
        }
        copyOf[0] = copyOf[0] - ((long) (67108845 & i20));
        long j17 = (long) (33554431 & i20);
        copyOf[1] = copyOf[1] - j17;
        for (int i27 = 2; i27 < 10; i27 += 2) {
            copyOf[i27] = copyOf[i27] - ((long) (67108863 & i20));
            int i28 = i27 + 1;
            copyOf[i28] = copyOf[i28] - j17;
        }
        for (int i29 = 0; i29 < 10; i29++) {
            copyOf[i29] = copyOf[i29] << zzb[i29];
        }
        byte[] bArr = new byte[32];
        for (int i30 = 0; i30 < 10; i30++) {
            int i31 = zza[i30];
            long j18 = copyOf[i30];
            bArr[i31] = (byte) ((int) (((long) bArr[i31]) | (j18 & 255)));
            int i32 = i31 + 1;
            bArr[i32] = (byte) ((int) (((long) bArr[i32]) | ((j18 >> 8) & 255)));
            int i33 = i31 + 2;
            bArr[i33] = (byte) ((int) (((long) bArr[i33]) | ((j18 >> 16) & 255)));
            int i34 = i31 + 3;
            bArr[i34] = (byte) ((int) (((long) bArr[i34]) | ((j18 >> 24) & 255)));
        }
        return bArr;
    }

    static long[] zzk(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i10 = 0; i10 < 10; i10++) {
            int i11 = zza[i10];
            jArr[i10] = ((((((long) (bArr[i11] & 255)) | (((long) (bArr[i11 + 1] & 255)) << 8)) | (((long) (bArr[i11 + 2] & 255)) << 16)) | (((long) (bArr[i11 + 3] & 255)) << 24)) >> zzb[i10]) & ((long) zzc[i10 & 1]);
        }
        return jArr;
    }
}
