package org.bouncycastle.crypto.engines;

public final class CAST6Engine extends CAST5Engine {
    protected static final int BLOCK_SIZE = 16;
    protected static final int ROUNDS = 12;
    protected int[] _Km = new int[48];
    protected int[] _Kr = new int[48];
    protected int[] _Tm = new int[192];
    protected int[] _Tr = new int[192];
    private int[] _workingKey = new int[8];

    /* access modifiers changed from: protected */
    public final void CAST_Decipher(int i10, int i11, int i12, int i13, int[] iArr) {
        int i14;
        int i15 = 0;
        while (true) {
            if (i15 >= 6) {
                break;
            }
            int i16 = (11 - i15) * 4;
            i12 ^= F1(i13, this._Km[i16], this._Kr[i16]);
            int i17 = i16 + 1;
            i11 ^= F2(i12, this._Km[i17], this._Kr[i17]);
            int i18 = i16 + 2;
            i10 ^= F3(i11, this._Km[i18], this._Kr[i18]);
            int i19 = i16 + 3;
            i13 ^= F1(i10, this._Km[i19], this._Kr[i19]);
            i15++;
        }
        for (i14 = 6; i14 < 12; i14++) {
            int i20 = (11 - i14) * 4;
            int i21 = i20 + 3;
            i13 ^= F1(i10, this._Km[i21], this._Kr[i21]);
            int i22 = i20 + 2;
            i10 ^= F3(i11, this._Km[i22], this._Kr[i22]);
            int i23 = i20 + 1;
            i11 ^= F2(i12, this._Km[i23], this._Kr[i23]);
            i12 ^= F1(i13, this._Km[i20], this._Kr[i20]);
        }
        iArr[0] = i10;
        iArr[1] = i11;
        iArr[2] = i12;
        iArr[3] = i13;
    }

    /* access modifiers changed from: protected */
    public final void CAST_Encipher(int i10, int i11, int i12, int i13, int[] iArr) {
        int i14;
        int i15 = 0;
        while (true) {
            if (i15 >= 6) {
                break;
            }
            int i16 = i15 * 4;
            i12 ^= F1(i13, this._Km[i16], this._Kr[i16]);
            int i17 = i16 + 1;
            i11 ^= F2(i12, this._Km[i17], this._Kr[i17]);
            int i18 = i16 + 2;
            i10 ^= F3(i11, this._Km[i18], this._Kr[i18]);
            int i19 = i16 + 3;
            i13 ^= F1(i10, this._Km[i19], this._Kr[i19]);
            i15++;
        }
        for (i14 = 6; i14 < 12; i14++) {
            int i20 = i14 * 4;
            int i21 = i20 + 3;
            i13 ^= F1(i10, this._Km[i21], this._Kr[i21]);
            int i22 = i20 + 2;
            i10 ^= F3(i11, this._Km[i22], this._Kr[i22]);
            int i23 = i20 + 1;
            i11 ^= F2(i12, this._Km[i23], this._Kr[i23]);
            i12 ^= F1(i13, this._Km[i20], this._Kr[i20]);
        }
        iArr[0] = i10;
        iArr[1] = i11;
        iArr[2] = i12;
        iArr[3] = i13;
    }

    /* access modifiers changed from: protected */
    public int decryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int[] iArr = new int[4];
        CAST_Decipher(BytesTo32bits(bArr, i10), BytesTo32bits(bArr, i10 + 4), BytesTo32bits(bArr, i10 + 8), BytesTo32bits(bArr, i10 + 12), iArr);
        Bits32ToBytes(iArr[0], bArr2, i11);
        Bits32ToBytes(iArr[1], bArr2, i11 + 4);
        Bits32ToBytes(iArr[2], bArr2, i11 + 8);
        Bits32ToBytes(iArr[3], bArr2, i11 + 12);
        return 16;
    }

    /* access modifiers changed from: protected */
    public int encryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int[] iArr = new int[4];
        CAST_Encipher(BytesTo32bits(bArr, i10), BytesTo32bits(bArr, i10 + 4), BytesTo32bits(bArr, i10 + 8), BytesTo32bits(bArr, i10 + 12), iArr);
        Bits32ToBytes(iArr[0], bArr2, i11);
        Bits32ToBytes(iArr[1], bArr2, i11 + 4);
        Bits32ToBytes(iArr[2], bArr2, i11 + 8);
        Bits32ToBytes(iArr[3], bArr2, i11 + 12);
        return 16;
    }

    public String getAlgorithmName() {
        return "CAST6";
    }

    public int getBlockSize() {
        return 16;
    }

    public void reset() {
    }

    /* access modifiers changed from: protected */
    public void setKey(byte[] bArr) {
        byte[] bArr2 = bArr;
        int i10 = 1518500249;
        int i11 = 19;
        for (int i12 = 0; i12 < 24; i12++) {
            for (int i13 = 0; i13 < 8; i13++) {
                int i14 = (i12 * 8) + i13;
                this._Tm[i14] = i10;
                i10 += 1859775393;
                this._Tr[i14] = i11;
                i11 = (i11 + 17) & 31;
            }
        }
        byte[] bArr3 = new byte[64];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        for (int i15 = 0; i15 < 8; i15++) {
            this._workingKey[i15] = BytesTo32bits(bArr3, i15 * 4);
        }
        for (int i16 = 0; i16 < 12; i16++) {
            int i17 = i16 * 2;
            int i18 = i17 * 8;
            int[] iArr = this._workingKey;
            iArr[6] = iArr[6] ^ F1(iArr[7], this._Tm[i18], this._Tr[i18]);
            int[] iArr2 = this._workingKey;
            int i19 = i18 + 1;
            iArr2[5] = iArr2[5] ^ F2(iArr2[6], this._Tm[i19], this._Tr[i19]);
            int[] iArr3 = this._workingKey;
            int i20 = i18 + 2;
            iArr3[4] = iArr3[4] ^ F3(iArr3[5], this._Tm[i20], this._Tr[i20]);
            int[] iArr4 = this._workingKey;
            int i21 = i18 + 3;
            iArr4[3] = F1(iArr4[4], this._Tm[i21], this._Tr[i21]) ^ iArr4[3];
            int[] iArr5 = this._workingKey;
            int i22 = i18 + 4;
            iArr5[2] = F2(iArr5[3], this._Tm[i22], this._Tr[i22]) ^ iArr5[2];
            int[] iArr6 = this._workingKey;
            int i23 = i18 + 5;
            iArr6[1] = F3(iArr6[2], this._Tm[i23], this._Tr[i23]) ^ iArr6[1];
            int[] iArr7 = this._workingKey;
            int i24 = i18 + 6;
            iArr7[0] = iArr7[0] ^ F1(iArr7[1], this._Tm[i24], this._Tr[i24]);
            int[] iArr8 = this._workingKey;
            int i25 = i18 + 7;
            iArr8[7] = F2(iArr8[0], this._Tm[i25], this._Tr[i25]) ^ iArr8[7];
            int i26 = (i17 + 1) * 8;
            int[] iArr9 = this._workingKey;
            iArr9[6] = iArr9[6] ^ F1(iArr9[7], this._Tm[i26], this._Tr[i26]);
            int[] iArr10 = this._workingKey;
            int i27 = i26 + 1;
            iArr10[5] = iArr10[5] ^ F2(iArr10[6], this._Tm[i27], this._Tr[i27]);
            int[] iArr11 = this._workingKey;
            int i28 = i26 + 2;
            iArr11[4] = iArr11[4] ^ F3(iArr11[5], this._Tm[i28], this._Tr[i28]);
            int[] iArr12 = this._workingKey;
            int i29 = i26 + 3;
            iArr12[3] = F1(iArr12[4], this._Tm[i29], this._Tr[i29]) ^ iArr12[3];
            int[] iArr13 = this._workingKey;
            int i30 = i26 + 4;
            iArr13[2] = F2(iArr13[3], this._Tm[i30], this._Tr[i30]) ^ iArr13[2];
            int[] iArr14 = this._workingKey;
            int i31 = i26 + 5;
            iArr14[1] = F3(iArr14[2], this._Tm[i31], this._Tr[i31]) ^ iArr14[1];
            int[] iArr15 = this._workingKey;
            int i32 = i26 + 6;
            iArr15[0] = iArr15[0] ^ F1(iArr15[1], this._Tm[i32], this._Tr[i32]);
            int[] iArr16 = this._workingKey;
            int i33 = i26 + 7;
            iArr16[7] = F2(iArr16[0], this._Tm[i33], this._Tr[i33]) ^ iArr16[7];
            int[] iArr17 = this._Kr;
            int i34 = i16 * 4;
            int[] iArr18 = this._workingKey;
            iArr17[i34] = iArr18[0] & 31;
            int i35 = i34 + 1;
            iArr17[i35] = iArr18[2] & 31;
            int i36 = i34 + 2;
            iArr17[i36] = iArr18[4] & 31;
            int i37 = i34 + 3;
            iArr17[i37] = iArr18[6] & 31;
            int[] iArr19 = this._Km;
            iArr19[i34] = iArr18[7];
            iArr19[i35] = iArr18[5];
            iArr19[i36] = iArr18[3];
            iArr19[i37] = iArr18[1];
        }
    }
}
