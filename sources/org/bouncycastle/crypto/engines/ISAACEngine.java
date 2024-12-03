package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

public class ISAACEngine implements StreamCipher {

    /* renamed from: a  reason: collision with root package name */
    private int f41428a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f41429b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f41430c = 0;
    private int[] engineState = null;
    private int index = 0;
    private boolean initialised = false;
    private byte[] keyStream = new byte[1024];
    private int[] results = null;
    private final int sizeL = 8;
    private final int stateArraySize = 256;
    private byte[] workingKey = null;

    private void isaac() {
        int i10;
        int i11;
        int i12 = this.f41429b;
        int i13 = this.f41430c + 1;
        this.f41430c = i13;
        this.f41429b = i12 + i13;
        for (int i14 = 0; i14 < 256; i14++) {
            int[] iArr = this.engineState;
            int i15 = iArr[i14];
            int i16 = i14 & 3;
            if (i16 == 0) {
                i11 = this.f41428a;
                i10 = i11 << 13;
            } else if (i16 == 1) {
                i11 = this.f41428a;
                i10 = i11 >>> 6;
            } else if (i16 == 2) {
                i11 = this.f41428a;
                i10 = i11 << 2;
            } else if (i16 != 3) {
                int i17 = this.f41428a + iArr[(i14 + 128) & 255];
                this.f41428a = i17;
                int i18 = iArr[(i15 >>> 2) & 255] + i17 + this.f41429b;
                iArr[i14] = i18;
                int[] iArr2 = this.results;
                int i19 = iArr[(i18 >>> 10) & 255] + i15;
                this.f41429b = i19;
                iArr2[i14] = i19;
            } else {
                i11 = this.f41428a;
                i10 = i11 >>> 16;
            }
            this.f41428a = i11 ^ i10;
            int i172 = this.f41428a + iArr[(i14 + 128) & 255];
            this.f41428a = i172;
            int i182 = iArr[(i15 >>> 2) & 255] + i172 + this.f41429b;
            iArr[i14] = i182;
            int[] iArr22 = this.results;
            int i192 = iArr[(i182 >>> 10) & 255] + i15;
            this.f41429b = i192;
            iArr22[i14] = i192;
        }
    }

    private void mix(int[] iArr) {
        int i10 = iArr[0];
        int i11 = iArr[1];
        int i12 = i10 ^ (i11 << 11);
        iArr[0] = i12;
        int i13 = iArr[3] + i12;
        iArr[3] = i13;
        int i14 = iArr[2];
        int i15 = i11 + i14;
        iArr[1] = i15;
        int i16 = i15 ^ (i14 >>> 2);
        iArr[1] = i16;
        int i17 = iArr[4] + i16;
        iArr[4] = i17;
        int i18 = i14 + i13;
        iArr[2] = i18;
        int i19 = i18 ^ (i13 << 8);
        iArr[2] = i19;
        int i20 = iArr[5] + i19;
        iArr[5] = i20;
        int i21 = i13 + i17;
        iArr[3] = i21;
        int i22 = i21 ^ (i17 >>> 16);
        iArr[3] = i22;
        int i23 = iArr[6] + i22;
        iArr[6] = i23;
        int i24 = i17 + i20;
        iArr[4] = i24;
        int i25 = (i20 << 10) ^ i24;
        iArr[4] = i25;
        int i26 = iArr[7] + i25;
        iArr[7] = i26;
        int i27 = i20 + i23;
        iArr[5] = i27;
        int i28 = (i23 >>> 4) ^ i27;
        iArr[5] = i28;
        int i29 = i12 + i28;
        iArr[0] = i29;
        int i30 = i23 + i26;
        iArr[6] = i30;
        int i31 = (i26 << 8) ^ i30;
        iArr[6] = i31;
        int i32 = i16 + i31;
        iArr[1] = i32;
        int i33 = i26 + i29;
        iArr[7] = i33;
        int i34 = (i29 >>> 9) ^ i33;
        iArr[7] = i34;
        iArr[2] = i19 + i34;
        iArr[0] = i29 + i32;
    }

    private void setKey(byte[] bArr) {
        this.workingKey = bArr;
        if (this.engineState == null) {
            this.engineState = new int[256];
        }
        if (this.results == null) {
            this.results = new int[256];
        }
        for (int i10 = 0; i10 < 256; i10++) {
            int[] iArr = this.engineState;
            this.results[i10] = 0;
            iArr[i10] = 0;
        }
        this.f41430c = 0;
        this.f41429b = 0;
        this.f41428a = 0;
        this.index = 0;
        int length = bArr.length + (bArr.length & 3);
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        for (int i11 = 0; i11 < length; i11 += 4) {
            this.results[i11 >>> 2] = Pack.littleEndianToInt(bArr2, i11);
        }
        int[] iArr2 = new int[8];
        for (int i12 = 0; i12 < 8; i12++) {
            iArr2[i12] = -1640531527;
        }
        for (int i13 = 0; i13 < 4; i13++) {
            mix(iArr2);
        }
        int i14 = 0;
        while (i14 < 2) {
            for (int i15 = 0; i15 < 256; i15 += 8) {
                for (int i16 = 0; i16 < 8; i16++) {
                    iArr2[i16] = iArr2[i16] + (i14 < 1 ? this.results[i15 + i16] : this.engineState[i15 + i16]);
                }
                mix(iArr2);
                for (int i17 = 0; i17 < 8; i17++) {
                    this.engineState[i15 + i17] = iArr2[i17];
                }
            }
            i14++;
        }
        isaac();
        this.initialised = true;
    }

    public String getAlgorithmName() {
        return "ISAAC";
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            setKey(((KeyParameter) cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to ISAAC init - " + cipherParameters.getClass().getName());
    }

    public int processBytes(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        if (!this.initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i10 + i11 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 + i11 <= bArr2.length) {
            for (int i13 = 0; i13 < i11; i13++) {
                if (this.index == 0) {
                    isaac();
                    this.keyStream = Pack.intToBigEndian(this.results);
                }
                byte[] bArr3 = this.keyStream;
                int i14 = this.index;
                bArr2[i13 + i12] = (byte) (bArr3[i14] ^ bArr[i13 + i10]);
                this.index = (i14 + 1) & 1023;
            }
            return i11;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
        setKey(this.workingKey);
    }

    public byte returnByte(byte b10) {
        if (this.index == 0) {
            isaac();
            this.keyStream = Pack.intToBigEndian(this.results);
        }
        byte[] bArr = this.keyStream;
        int i10 = this.index;
        byte b11 = (byte) (b10 ^ bArr[i10]);
        this.index = (i10 + 1) & 1023;
        return b11;
    }
}
