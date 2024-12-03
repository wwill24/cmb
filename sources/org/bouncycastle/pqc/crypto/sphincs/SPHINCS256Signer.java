package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.MessageSigner;
import org.bouncycastle.pqc.crypto.sphincs.Tree;
import org.bouncycastle.util.Pack;

public class SPHINCS256Signer implements MessageSigner {
    private final HashFunctions hashFunctions;
    private byte[] keyData;

    public SPHINCS256Signer(Digest digest, Digest digest2) {
        if (digest.getDigestSize() != 32) {
            throw new IllegalArgumentException("n-digest needs to produce 32 bytes of output");
        } else if (digest2.getDigestSize() == 64) {
            this.hashFunctions = new HashFunctions(digest, digest2);
        } else {
            throw new IllegalArgumentException("2n-digest needs to produce 64 bytes of output");
        }
    }

    static void compute_authpath_wots(HashFunctions hashFunctions2, byte[] bArr, byte[] bArr2, int i10, Tree.leafaddr leafaddr, byte[] bArr3, byte[] bArr4, int i11) {
        Tree.leafaddr leafaddr2 = leafaddr;
        Tree.leafaddr leafaddr3 = new Tree.leafaddr(leafaddr2);
        byte[] bArr5 = new byte[2048];
        byte[] bArr6 = new byte[1024];
        byte[] bArr7 = new byte[68608];
        leafaddr3.subleaf = 0;
        while (true) {
            long j10 = leafaddr3.subleaf;
            if (j10 >= 32) {
                break;
            }
            Seed.get_seed(hashFunctions2, bArr6, (int) (j10 * 32), bArr3, leafaddr3);
            leafaddr3.subleaf++;
        }
        HashFunctions hashFunctions3 = hashFunctions2;
        Wots wots = new Wots();
        leafaddr3.subleaf = 0;
        while (true) {
            long j11 = leafaddr3.subleaf;
            if (j11 >= 32) {
                break;
            }
            wots.wots_pkgen(hashFunctions2, bArr7, (int) (67 * j11 * 32), bArr6, (int) (j11 * 32), bArr4, 0);
            leafaddr3.subleaf++;
            HashFunctions hashFunctions4 = hashFunctions2;
        }
        leafaddr3.subleaf = 0;
        while (true) {
            long j12 = leafaddr3.subleaf;
            if (j12 >= 32) {
                break;
            }
            Tree.l_tree(hashFunctions2, bArr5, (int) ((j12 * 32) + 1024), bArr7, (int) (j12 * 67 * 32), bArr4, 0);
            leafaddr3.subleaf++;
        }
        int i12 = 0;
        for (int i13 = 32; i13 > 0; i13 >>>= 1) {
            for (int i14 = 0; i14 < i13; i14 += 2) {
                hashFunctions2.hash_2n_n_mask(bArr5, ((i13 >>> 1) * 32) + ((i14 >>> 1) * 32), bArr5, (i13 * 32) + (i14 * 32), bArr4, (i12 + 7) * 2 * 32);
            }
            i12++;
        }
        int i15 = (int) leafaddr2.subleaf;
        int i16 = i11;
        for (int i17 = 0; i17 < i16; i17++) {
            System.arraycopy(bArr5, ((32 >>> i17) * 32) + (((i15 >>> i17) ^ 1) * 32), bArr2, i10 + (i17 * 32), 32);
        }
        System.arraycopy(bArr5, 32, bArr, 0, 32);
    }

    static void validate_authpath(HashFunctions hashFunctions2, byte[] bArr, byte[] bArr2, int i10, byte[] bArr3, int i11, byte[] bArr4, int i12) {
        byte[] bArr5 = new byte[64];
        if ((i10 & 1) != 0) {
            for (int i13 = 0; i13 < 32; i13++) {
                bArr5[i13 + 32] = bArr2[i13];
            }
            for (int i14 = 0; i14 < 32; i14++) {
                bArr5[i14] = bArr3[i11 + i14];
            }
        } else {
            for (int i15 = 0; i15 < 32; i15++) {
                bArr5[i15] = bArr2[i15];
            }
            for (int i16 = 0; i16 < 32; i16++) {
                bArr5[i16 + 32] = bArr3[i11 + i16];
            }
        }
        int i17 = i11 + 32;
        int i18 = 0;
        int i19 = i10;
        while (i18 < i12 - 1) {
            int i20 = i19 >>> 1;
            if ((i20 & 1) != 0) {
                hashFunctions2.hash_2n_n_mask(bArr5, 32, bArr5, 0, bArr4, (i18 + 7) * 2 * 32);
                for (int i21 = 0; i21 < 32; i21++) {
                    bArr5[i21] = bArr3[i17 + i21];
                }
            } else {
                hashFunctions2.hash_2n_n_mask(bArr5, 0, bArr5, 0, bArr4, (i18 + 7) * 2 * 32);
                for (int i22 = 0; i22 < 32; i22++) {
                    bArr5[i22 + 32] = bArr3[i17 + i22];
                }
            }
            i17 += 32;
            i18++;
            i19 = i20;
        }
        hashFunctions2.hash_2n_n_mask(bArr, 0, bArr5, 0, bArr4, ((i12 + 7) - 1) * 2 * 32);
    }

    private void zerobytes(byte[] bArr, int i10, int i11) {
        for (int i12 = 0; i12 != i11; i12++) {
            bArr[i10 + i12] = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] crypto_sign(HashFunctions hashFunctions2, byte[] bArr, byte[] bArr2) {
        HashFunctions hashFunctions3 = hashFunctions2;
        byte[] bArr3 = bArr;
        byte[] bArr4 = new byte[41000];
        byte[] bArr5 = new byte[32];
        byte[] bArr6 = new byte[64];
        long[] jArr = new long[8];
        byte[] bArr7 = new byte[32];
        byte[] bArr8 = new byte[32];
        byte[] bArr9 = new byte[1024];
        byte[] bArr10 = new byte[1088];
        for (int i10 = 0; i10 < 1088; i10++) {
            bArr10[i10] = bArr2[i10];
        }
        System.arraycopy(bArr10, 1056, bArr4, 40968, 32);
        Digest messageHash = hashFunctions2.getMessageHash();
        byte[] bArr11 = new byte[messageHash.getDigestSize()];
        messageHash.update(bArr4, 40968, 32);
        messageHash.update(bArr3, 0, bArr3.length);
        messageHash.doFinal(bArr11, 0);
        zerobytes(bArr4, 40968, 32);
        for (int i11 = 0; i11 != 8; i11++) {
            jArr[i11] = Pack.littleEndianToLong(bArr11, i11 * 8);
        }
        long j10 = jArr[0] & 1152921504606846975L;
        System.arraycopy(bArr11, 16, bArr5, 0, 32);
        System.arraycopy(bArr5, 0, bArr4, 39912, 32);
        Tree.leafaddr leafaddr = new Tree.leafaddr();
        leafaddr.level = 11;
        byte[] bArr12 = bArr10;
        leafaddr.subtree = 0;
        leafaddr.subleaf = 0;
        System.arraycopy(bArr12, 32, bArr4, 39944, 1024);
        byte[] bArr13 = bArr12;
        byte[] bArr14 = bArr9;
        byte[] bArr15 = bArr8;
        byte[] bArr16 = bArr7;
        Tree.treehash(hashFunctions2, bArr4, 40968, 5, bArr13, leafaddr, bArr4, 39944);
        Digest messageHash2 = hashFunctions2.getMessageHash();
        messageHash2.update(bArr4, 39912, 1088);
        messageHash2.update(bArr3, 0, bArr3.length);
        messageHash2.doFinal(bArr6, 0);
        Tree.leafaddr leafaddr2 = new Tree.leafaddr();
        leafaddr2.level = 12;
        leafaddr2.subleaf = (long) ((int) (j10 & 31));
        leafaddr2.subtree = j10 >>> 5;
        for (int i12 = 0; i12 < 32; i12++) {
            bArr4[i12] = bArr5[i12];
        }
        byte[] bArr17 = bArr13;
        byte[] bArr18 = bArr14;
        System.arraycopy(bArr17, 32, bArr18, 0, 1024);
        for (int i13 = 0; i13 < 8; i13++) {
            bArr4[32 + i13] = (byte) ((int) ((j10 >>> (i13 * 8)) & 255));
        }
        byte[] bArr19 = bArr15;
        Seed.get_seed(hashFunctions3, bArr19, 0, bArr17, leafaddr2);
        new Horst();
        byte[] bArr20 = bArr19;
        byte[] bArr21 = bArr17;
        Wots wots = new Wots();
        int horst_sign = 40 + Horst.horst_sign(hashFunctions2, bArr4, 40, bArr16, bArr19, bArr18, bArr6);
        int i14 = 0;
        for (int i15 = 12; i14 < i15; i15 = 12) {
            leafaddr2.level = i14;
            byte[] bArr22 = bArr21;
            Seed.get_seed(hashFunctions3, bArr20, 0, bArr22, leafaddr2);
            byte[] bArr23 = bArr4;
            byte[] bArr24 = bArr22;
            int i16 = horst_sign;
            byte[] bArr25 = bArr18;
            wots.wots_sign(hashFunctions2, bArr23, horst_sign, bArr16, bArr20, bArr25);
            int i17 = i16 + 2144;
            compute_authpath_wots(hashFunctions2, bArr16, bArr23, i17, leafaddr2, bArr24, bArr25, 5);
            horst_sign = i17 + 160;
            long j11 = leafaddr2.subtree;
            leafaddr2.subleaf = (long) ((int) (j11 & 31));
            leafaddr2.subtree = j11 >>> 5;
            i14++;
            bArr21 = bArr24;
            bArr18 = bArr18;
        }
        zerobytes(bArr21, 0, 1088);
        return bArr4;
    }

    public byte[] generateSignature(byte[] bArr) {
        return crypto_sign(this.hashFunctions, bArr, this.keyData);
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        if (!z10) {
            this.keyData = ((SPHINCSPublicKeyParameters) cipherParameters).getKeyData();
        } else if (cipherParameters instanceof ParametersWithRandom) {
            this.keyData = ((SPHINCSPrivateKeyParameters) ((ParametersWithRandom) cipherParameters).getParameters()).getKeyData();
        } else {
            this.keyData = ((SPHINCSPrivateKeyParameters) cipherParameters).getKeyData();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean verify(HashFunctions hashFunctions2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = bArr;
        byte[] bArr5 = bArr2;
        byte[] bArr6 = new byte[2144];
        byte[] bArr7 = new byte[32];
        byte[] bArr8 = new byte[32];
        byte[] bArr9 = new byte[41000];
        byte[] bArr10 = new byte[1056];
        if (bArr5.length == 41000) {
            byte[] bArr11 = new byte[64];
            for (int i10 = 0; i10 < 1056; i10++) {
                bArr10[i10] = bArr3[i10];
            }
            byte[] bArr12 = new byte[32];
            for (int i11 = 0; i11 < 32; i11++) {
                bArr12[i11] = bArr5[i11];
            }
            System.arraycopy(bArr5, 0, bArr9, 0, 41000);
            Digest messageHash = hashFunctions2.getMessageHash();
            messageHash.update(bArr12, 0, 32);
            messageHash.update(bArr10, 0, 1056);
            messageHash.update(bArr4, 0, bArr4.length);
            messageHash.doFinal(bArr11, 0);
            long j10 = 0;
            for (int i12 = 0; i12 < 8; i12++) {
                j10 ^= ((long) (bArr9[32 + i12] & 255)) << (i12 * 8);
            }
            new Horst();
            Horst.horst_verify(hashFunctions2, bArr8, bArr9, 40, bArr10, bArr11);
            Wots wots = new Wots();
            int i13 = 0;
            int i14 = 13352;
            while (i13 < 12) {
                byte[] bArr13 = bArr10;
                wots.wots_verify(hashFunctions2, bArr6, bArr9, i14, bArr8, bArr10);
                int i15 = i14 + 2144;
                Tree.l_tree(hashFunctions2, bArr7, 0, bArr6, 0, bArr13, 0);
                byte[] bArr14 = bArr9;
                byte[] bArr15 = bArr8;
                byte[] bArr16 = bArr7;
                validate_authpath(hashFunctions2, bArr8, bArr7, (int) (31 & j10), bArr14, i15, bArr13, 5);
                j10 >>= 5;
                i14 = i15 + 160;
                i13++;
                bArr9 = bArr14;
                bArr10 = bArr13;
            }
            byte[] bArr17 = bArr10;
            byte[] bArr18 = bArr8;
            boolean z10 = true;
            for (int i16 = 0; i16 < 32; i16++) {
                if (bArr18[i16] != bArr17[i16 + 1024]) {
                    z10 = false;
                }
            }
            return z10;
        }
        throw new IllegalArgumentException("signature wrong size");
    }

    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        return verify(this.hashFunctions, bArr, bArr2, this.keyData);
    }
}
