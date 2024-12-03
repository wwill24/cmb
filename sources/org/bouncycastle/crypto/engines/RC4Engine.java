package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;

public class RC4Engine implements StreamCipher {
    private static final int STATE_LENGTH = 256;
    private byte[] engineState = null;
    private byte[] workingKey = null;

    /* renamed from: x  reason: collision with root package name */
    private int f41432x = 0;

    /* renamed from: y  reason: collision with root package name */
    private int f41433y = 0;

    private void setKey(byte[] bArr) {
        this.workingKey = bArr;
        this.f41432x = 0;
        this.f41433y = 0;
        if (this.engineState == null) {
            this.engineState = new byte[256];
        }
        for (int i10 = 0; i10 < 256; i10++) {
            this.engineState[i10] = (byte) i10;
        }
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < 256; i13++) {
            byte[] bArr2 = this.engineState;
            byte b10 = bArr2[i13];
            i12 = ((bArr[i11] & 255) + b10 + i12) & 255;
            bArr2[i13] = bArr2[i12];
            bArr2[i12] = b10;
            i11 = (i11 + 1) % bArr.length;
        }
    }

    public String getAlgorithmName() {
        return "RC4";
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            this.workingKey = key;
            setKey(key);
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to RC4 init - " + cipherParameters.getClass().getName());
    }

    public int processBytes(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        if (i10 + i11 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 + i11 <= bArr2.length) {
            for (int i13 = 0; i13 < i11; i13++) {
                int i14 = (this.f41432x + 1) & 255;
                this.f41432x = i14;
                byte[] bArr3 = this.engineState;
                byte b10 = bArr3[i14];
                int i15 = (this.f41433y + b10) & 255;
                this.f41433y = i15;
                bArr3[i14] = bArr3[i15];
                bArr3[i15] = b10;
                bArr2[i13 + i12] = (byte) (bArr3[(bArr3[i14] + b10) & 255] ^ bArr[i13 + i10]);
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
        int i10 = (this.f41432x + 1) & 255;
        this.f41432x = i10;
        byte[] bArr = this.engineState;
        byte b11 = bArr[i10];
        int i11 = (this.f41433y + b11) & 255;
        this.f41433y = i11;
        bArr[i10] = bArr[i11];
        bArr[i11] = b11;
        return (byte) (b10 ^ bArr[(bArr[i10] + b11) & 255]);
    }
}
