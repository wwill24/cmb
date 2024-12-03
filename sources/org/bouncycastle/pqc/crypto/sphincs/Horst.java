package org.bouncycastle.pqc.crypto.sphincs;

import com.google.firebase.database.core.ValidationPath;

class Horst {
    static final int HORST_K = 32;
    static final int HORST_LOGT = 16;
    static final int HORST_SIGBYTES = 13312;
    static final int HORST_SKBYTES = 32;
    static final int HORST_T = 65536;
    static final int N_MASKS = 32;

    Horst() {
    }

    static void expand_seed(byte[] bArr, byte[] bArr2) {
        Seed.prg(bArr, 0, 2097152, bArr2, 0);
    }

    static int horst_sign(HashFunctions hashFunctions, byte[] bArr, int i10, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        byte[] bArr6 = new byte[2097152];
        byte[] bArr7 = new byte[4194272];
        expand_seed(bArr6, bArr3);
        for (int i11 = 0; i11 < 65536; i11++) {
            hashFunctions.hash_n_n(bArr7, (65535 + i11) * 32, bArr6, i11 * 32);
        }
        HashFunctions hashFunctions2 = hashFunctions;
        for (int i12 = 0; i12 < 16; i12++) {
            int i13 = 16 - i12;
            long j10 = (long) ((1 << i13) - 1);
            int i14 = 1 << (i13 - 1);
            long j11 = (long) (i14 - 1);
            int i15 = 0;
            while (i15 < i14) {
                hashFunctions.hash_2n_n_mask(bArr7, (int) ((((long) i15) + j11) * 32), bArr7, (int) ((((long) (i15 * 2)) + j10) * 32), bArr4, i12 * 2 * 32);
                i15++;
                i14 = i14;
                j11 = j11;
            }
        }
        int i16 = 2016;
        int i17 = i10;
        while (i16 < 4064) {
            bArr[i17] = bArr7[i16];
            i16++;
            i17++;
        }
        for (int i18 = 0; i18 < 32; i18++) {
            int i19 = i18 * 2;
            int i20 = (bArr5[i19] & 255) + ((bArr5[i19 + 1] & 255) << 8);
            int i21 = 0;
            while (i21 < 32) {
                bArr[i17] = bArr6[(i20 * 32) + i21];
                i21++;
                i17++;
            }
            int i22 = i20 + 65535;
            for (int i23 = 0; i23 < 10; i23++) {
                int i24 = (i22 & 1) != 0 ? i22 + 1 : i22 - 1;
                int i25 = 0;
                while (i25 < 32) {
                    bArr[i17] = bArr7[(i24 * 32) + i25];
                    i25++;
                    i17++;
                }
                i22 = (i24 - 1) / 2;
            }
        }
        for (int i26 = 0; i26 < 32; i26++) {
            bArr2[i26] = bArr7[i26];
        }
        return HORST_SIGBYTES;
    }

    static int horst_verify(HashFunctions hashFunctions, byte[] bArr, byte[] bArr2, int i10, byte[] bArr3, byte[] bArr4) {
        int i11;
        HashFunctions hashFunctions2 = hashFunctions;
        byte[] bArr5 = bArr2;
        int i12 = i10;
        byte[] bArr6 = new byte[1024];
        int i13 = i12 + 2048;
        int i14 = 0;
        while (i14 < 32) {
            int i15 = i14 * 2;
            int i16 = (bArr4[i15] & 255) + ((bArr4[i15 + 1] & 255) << 8);
            if ((i16 & 1) == 0) {
                hashFunctions2.hash_n_n(bArr6, 0, bArr5, i13);
                for (int i17 = 0; i17 < 32; i17++) {
                    bArr6[i17 + 32] = bArr5[i13 + 32 + i17];
                }
            } else {
                hashFunctions2.hash_n_n(bArr6, 32, bArr5, i13);
                for (int i18 = 0; i18 < 32; i18++) {
                    bArr6[i18] = bArr5[i13 + 32 + i18];
                }
            }
            int i19 = i13 + 64;
            int i20 = 1;
            while (i20 < 10) {
                int i21 = i16 >>> 1;
                if ((i21 & 1) == 0) {
                    i11 = i20;
                    hashFunctions.hash_2n_n_mask(bArr6, 0, bArr6, 0, bArr3, (i20 - 1) * 2 * 32);
                    for (int i22 = 0; i22 < 32; i22++) {
                        bArr6[i22 + 32] = bArr5[i19 + i22];
                    }
                } else {
                    i11 = i20;
                    hashFunctions.hash_2n_n_mask(bArr6, 32, bArr6, 0, bArr3, (i11 - 1) * 2 * 32);
                    for (int i23 = 0; i23 < 32; i23++) {
                        bArr6[i23] = bArr5[i19 + i23];
                    }
                }
                i19 += 32;
                i20 = i11 + 1;
                i16 = i21;
            }
            int i24 = i16 >>> 1;
            hashFunctions.hash_2n_n_mask(bArr6, 0, bArr6, 0, bArr3, 576);
            for (int i25 = 0; i25 < 32; i25++) {
                if (bArr5[(i24 * 32) + i12 + i25] != bArr6[i25]) {
                    for (int i26 = 0; i26 < 32; i26++) {
                        bArr[i26] = 0;
                    }
                    return -1;
                }
            }
            i14++;
            i13 = i19;
        }
        for (int i27 = 0; i27 < 32; i27++) {
            hashFunctions.hash_2n_n_mask(bArr6, i27 * 32, bArr2, i12 + (i27 * 2 * 32), bArr3, 640);
        }
        for (int i28 = 0; i28 < 16; i28++) {
            hashFunctions.hash_2n_n_mask(bArr6, i28 * 32, bArr6, i28 * 2 * 32, bArr3, 704);
        }
        for (int i29 = 0; i29 < 8; i29++) {
            hashFunctions.hash_2n_n_mask(bArr6, i29 * 32, bArr6, i29 * 2 * 32, bArr3, ValidationPath.MAX_PATH_LENGTH_BYTES);
        }
        for (int i30 = 0; i30 < 4; i30++) {
            hashFunctions.hash_2n_n_mask(bArr6, i30 * 32, bArr6, i30 * 2 * 32, bArr3, 832);
        }
        for (int i31 = 0; i31 < 2; i31++) {
            hashFunctions.hash_2n_n_mask(bArr6, i31 * 32, bArr6, i31 * 2 * 32, bArr3, 896);
        }
        hashFunctions.hash_2n_n_mask(bArr, 0, bArr6, 0, bArr3, 960);
        return 0;
    }
}
