package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Strings;

class HashFunctions {
    private static final byte[] hashc = Strings.toByteArray("expand 32-byte to 64-byte state!");
    private final Digest dig256;
    private final Digest dig512;
    private final Permute perm;

    HashFunctions(Digest digest) {
        this(digest, (Digest) null);
    }

    HashFunctions(Digest digest, Digest digest2) {
        this.perm = new Permute();
        this.dig256 = digest;
        this.dig512 = digest2;
    }

    /* access modifiers changed from: package-private */
    public Digest getMessageHash() {
        return this.dig512;
    }

    /* access modifiers changed from: package-private */
    public int hash_2n_n(byte[] bArr, int i10, byte[] bArr2, int i11) {
        byte[] bArr3 = new byte[64];
        for (int i12 = 0; i12 < 32; i12++) {
            bArr3[i12] = bArr2[i11 + i12];
            bArr3[i12 + 32] = hashc[i12];
        }
        this.perm.chacha_permute(bArr3, bArr3);
        for (int i13 = 0; i13 < 32; i13++) {
            bArr3[i13] = (byte) (bArr3[i13] ^ bArr2[(i11 + i13) + 32]);
        }
        this.perm.chacha_permute(bArr3, bArr3);
        for (int i14 = 0; i14 < 32; i14++) {
            bArr[i10 + i14] = bArr3[i14];
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int hash_2n_n_mask(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, int i12) {
        byte[] bArr4 = new byte[64];
        for (int i13 = 0; i13 < 64; i13++) {
            bArr4[i13] = (byte) (bArr2[i11 + i13] ^ bArr3[i12 + i13]);
        }
        return hash_2n_n(bArr, i10, bArr4, 0);
    }

    /* access modifiers changed from: package-private */
    public int hash_n_n(byte[] bArr, int i10, byte[] bArr2, int i11) {
        byte[] bArr3 = new byte[64];
        for (int i12 = 0; i12 < 32; i12++) {
            bArr3[i12] = bArr2[i11 + i12];
            bArr3[i12 + 32] = hashc[i12];
        }
        this.perm.chacha_permute(bArr3, bArr3);
        for (int i13 = 0; i13 < 32; i13++) {
            bArr[i10 + i13] = bArr3[i13];
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int hash_n_n_mask(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, int i12) {
        byte[] bArr4 = new byte[32];
        for (int i13 = 0; i13 < 32; i13++) {
            bArr4[i13] = (byte) (bArr2[i11 + i13] ^ bArr3[i12 + i13]);
        }
        return hash_n_n(bArr, i10, bArr4, 0);
    }

    /* access modifiers changed from: package-private */
    public int varlen_hash(byte[] bArr, int i10, byte[] bArr2, int i11) {
        this.dig256.update(bArr2, 0, i11);
        this.dig256.doFinal(bArr, i10);
        return 0;
    }
}
